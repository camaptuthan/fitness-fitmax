package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.RoleRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;

 

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    StudioRepository studioRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<UserDTO> findAll() {
        // Find all user from mapper
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User u : userList) {
            UserDTO userDTO = modelMapper.map(u, UserDTO.class);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }



    @Override
    public User save(UserDTO u) {
        User user = new User();
        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO u) {
        try {
            User user = userRepository.getById(u.getEmail());
            Studio studio = new Studio();
            studio.setId(u.getStudioId());

            Role role = new Role();

            role.setId(u.getRoleId());


            user.setRole(role);
            user.setStudio(studio);
            System.out.println("==================================" + user);


            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disableUser(String email) {
        User user = userRepository.getById(email);
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void enableById(String email) {
        User user = userRepository.getById(email);
        user.setStatus(true);
        userRepository.save(user);

    }

    @Override
    public UserDTO getUserById(String email) {
        User user = userRepository.getById(email);
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }


    @Override
    public List<UserDTO> findAllUser(String keyword) {
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> userDTOList1 = new ArrayList<>();
        List<User> userList = userRepository.findAllUser(keyword);
        for (User u : userList) {
            UserDTO userDTO = mapper.map(u, UserDTO.class);
            userDTOList1.add(userDTO);
        }
        return userDTOList1;
    }

    @Override
    public List<User> findAllUserNameContaining(String email) {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(UserDTO userDTO) {

        User user1 = userRepository.getById(userDTO.getEmail());
        user1.setAvatar(userDTO.getAvatar());
        userRepository.save(user1);

    }

    public void registerUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role r = new Role();
        r.setId("ROLE0006");
        user.setRole(r);
        Studio s = new Studio();
        s.setId("STU0001");
        user.setStudio(s);
        user.setDate(new Date());
        user.setStatus(false);
        //set random ver code
        String randomVerificationCode = RandomString.make(64);
        user.setVerificationCode(randomVerificationCode);
        userRepository.save(user);
    }

//    @Override
//    public List<UserDTO> findAllUserNameContaining(String email) {
//        ModelMapper mapper = new ModelMapper();
//        List<UserDTO>  userDTOList = new ArrayList<>();
//        List<User> userList = userRepository.findAllUserNameContaining(email);
//        for(User u : userList){
//            UserDTO userDTO = mapper.map(u, UserDTO.class);
//            userDTOList.add(userDTO);
//        }
//        return userDTOList;
//    }


    //check email exist ,phone may be optional
    @Override
    public List<Object> isUserPresent(User user) {
        boolean userExists = false;
        String message = null;
        Optional<User> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserEmail.isPresent()) {
            userExists = true;
            message = "Email Already Present!";
        }
//        Optional<User> existingUserMobile = userRepository.findByMobile(user.getPhone());
//        if(existingUserMobile.isPresent()){
//            userExists = true;
//            message = "Mobile Number Already Present!";
//        }
//        if (existingUserEmail.isPresent() && existingUserMobile.isPresent()) {
//            message = "Email and Mobile Number Both Already Present!";
//        }
        System.out.println("existingUserEmail.isPresent() - " + existingUserEmail.isPresent());
        return Arrays.asList(userExists, message);

    }

    @Override
    public void sendVerificationEmail(User user, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "ducnvhe141646@fpt.edu.vn";
        String senderName = "Fitness Service Management System";
        String subject = "Please verify your registration";
        String verifyURL = siteUrl + "/verify?code=" + user.getVerificationCode();
        String content = "Dear " + user.getFirstName() + "" + user.getLastName() + ",<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"" + verifyURL + "\" >VERIFY</a></h3>"
                + "Thank you,<br>"
                + "From FSM.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);


    }

    // ma hoa password
    private void setPasswordEncoder(User u) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
    }

    @Override
    public boolean verify(String code) {
        User u = userRepository.findByVerificationCode(code);
        System.out.println("Verify code is :" + u.getVerificationCode());
        if (u == null) {
            return false;
        } else {
            u.setStatus(true);
            u.setVerificationCode(null);
            userRepository.save(u);
            return true;
        }
    }

}


