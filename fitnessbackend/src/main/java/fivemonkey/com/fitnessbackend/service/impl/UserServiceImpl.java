package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.configuration.ModelMapperConfiguration;
import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.UserDTO;
import fivemonkey.com.fitnessbackend.entities.*;
import fivemonkey.com.fitnessbackend.repository.RegistrationRepository;
import fivemonkey.com.fitnessbackend.repository.RoleRepository;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.repository.UserRepository;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
import fivemonkey.com.fitnessbackend.service.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private final int OTP_EXPIRATION_TIME_MINUTES = 5;

    private Map<String, String> otpMap = new HashMap<>();
    @Autowired
    UserRepository userRepository;

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    StudioRepository studioRepository;

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ModelMapperConfiguration<User, UserDTO> modelMapper;


    @Autowired
    ModelMapperConfiguration<User, UserDTO> modelMapperConfiguration;


    @Override
    public List<UserDTO> findAll() {
        // Find all user from mapper
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User u : userList) {
            UserDTO userDTO = modelMapperConfiguration.map(u, UserDTO.class);
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
            User user = userRepository.getUserByEmail(u.getEmail());
            Studio studio = new Studio();
            studio.setId(u.getStudioId());
            Role role = new Role();
            role.setId(u.getRoleId());
            user.setRole(role);

            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void disableUser(String email) {
        User user = userRepository.getUserByEmail(email);
        user.setStatus(false);
        userRepository.save(user);
    }

    @Override
    public void enableById(String email) {
        User user = userRepository.getUserByEmail(email);
        user.setStatus(true);
        userRepository.save(user);

    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return userDTO;
    }
    @Override
    public List<UserDTO> listUserByAdmin() {
        List<User> userList = userRepository.listUserByAdmin();
        return modelMapperConfiguration.mapList(userList, UserDTO.class);
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

        User user1 = userRepository.getUserByEmail(userDTO.getEmail());
        user1.setFirstName(userDTO.getFirstName());
        user1.setLastName(userDTO.getLastName());
        user1.setPhone(userDTO.getPhone());
        user1.setAddress(userDTO.getAddress());
        userRepository.save(user1);

    }

    @Override
    public void updateUserAvatar(UserDTO userDTO) {

        User user2 = userRepository.getUserByEmail(userDTO.getEmail());
        user2.setAvatar(userDTO.getAvatar());

        userRepository.save(user2);

    }

    @Override
    public UserDTO saveThumbnail(String thumbNail, String email) {
        if (thumbNail.isBlank()) return null;
        User user = userRepository.getUserByEmail(email);
        user.setAvatar(thumbNail);
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    @Override
    public void updateUserPassword(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public void registerUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role r = new Role();
        //register auto role trainee
        r.setId("ROLE05");
        user.setRole(r);
//        user.setStudio(s);
        user.setDate(new Date());
        user.setStatus(false);
        //save to trainee table
        Trainee trainee = new Trainee();
        trainee.setEmail(user.getEmail());
        trainee.setUser(user);
        user.setTrainee(trainee);
        //set random ver code
        String randomVerificationCode = RandomString.make(64);
        user.setVerificationCode(randomVerificationCode);
        userRepository.save(user);

    }

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
        System.out.println("existingUserEmail.isPresent() - " + existingUserEmail.isPresent());
        return Arrays.asList(userExists, message);

    }

    @Override
    public void sendVerificationEmail(User user, String siteUrl) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "ducnvhe141646@fpt.edu.vn";
        String senderName = "Fitness Service Management System";
        String subject = "Please verify your registration";
        String verifyURL = siteUrl + "/user/verify?code=" + user.getVerificationCode();
        String content = "Dear " + user.getFirstName() + user.getLastName() + ",<br>"
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


    @Override
    public boolean verify(String code) {
        User u = userRepository.findByVerificationCode(code);
        if (u == null) {
            return false;
        } else {
            u.setStatus(true);
            u.setVerificationCode("");
            userRepository.save(u);
            return true;
        }
    }


    //send otp to forgot password
    @Override
    public void sendOTP(String email) throws MessagingException, UnsupportedEncodingException {
        String otp = generateOTP();
        // send the OTP to the user's email
        otpMap.put(email, otp);
        // set the expiration time for the OTP
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                otpMap.remove(email);
            }
        }, OTP_EXPIRATION_TIME_MINUTES * 60 * 1000);
        String toAddress = email;
        String fromAddress = "ducnvhe141646@fpt.edu.vn";
        String senderName = "Fitness Service Management System";
        String subject = "Please verify ";

        String content = "Dear ,<br>"
                + "This is your otp please verify otp now :<br>"
                + "<h3>" + otp + "</h3> <br>"
                + "<a>" + "It's expired time after " + OTP_EXPIRATION_TIME_MINUTES + " minutes </a><br>"
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

    @Override
    public boolean verifyOTP(String email, String otp) {
        String storedOTP = otpMap.get(email);
        //check otp equal or not >>>
        return storedOTP != null && storedOTP.equals(otp);
    }


    private String generateOTP() {
        // generate a random 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    @Override
    public void resetPassword(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public long countTrainer(String roleId) {
        return userRepository.getCountOfTrainer("ROLE04");
    }

    @Override
    public List<User> listAllTrainer(String role) {
        return null;
    }

    @Override
    public List<UserDTO> listUserByManage(String studioId, String keyword, String roleId) {
        List<UserDTO> userList = null;
        List<Registration> registrationList = null;
        List<Services> listServices = userRepository.listServicesID(studioId);

        for (Services s : listServices) {
            registrationList = registrationRepository.getRegistrationByServices(s.getId());
            if (registrationList != null) {
                for (Registration r : registrationList) {
                    userList = getUserByFieldsByManager(r.getTrainee().getEmail(), keyword, roleId);
                }
            }
        }
        return userList;
    }

    @Override
    public List<UserDTO> listUserByAssistant(String studioId, String keyword, String roleId) {
        List<UserDTO> userList = null;
        List<Registration> registrationList = null;
        List<Services> listServices = userRepository.listServicesID(studioId);

        for (Services s : listServices) {
            registrationList = registrationRepository.getRegistrationByServices(s.getId());
            if (registrationList != null) {
                for (Registration r : registrationList) {
                    userList = getUserByFieldsByAssistant(r.getTrainee().getEmail(), keyword, roleId);
                }
            }
        }
        return userList;
    }

    public List<User> getUserByRoleId(String roleId) {
        return userRepository.listAllTrainer(roleId);

    }


    @Override
    public List<UserDTO> getUserByFieldsByAdmin(String keyword, String cityName, String roleId, String studioId) {
        Session session = sessionFactory.openSession();
        String query = "select u from User u where u.role.id not in('ROLE01') ";
        if (!"".equals(keyword)) {
            query += " and concat(u.email,'',u.firstName,'',u.lastName,'',u.role.name,'',u.studio.name) like '%" + keyword + "%' ";
        }
        if (!"All".equals(cityName)) {
            query += " and u.city.name = '" + cityName + "' ";
        }
        if (!"All".equals(roleId)) {
            query += " and u.role.id = '" + roleId + "' ";
        }
        if (!"All".equals(studioId)) {
            query += " and u.studio.id = '" + studioId + "' ";
        }
        Query<User> query1 = session.createQuery(query, User.class);
        return modelMapperConfiguration.mapList(query1.getResultList(), UserDTO.class);
    }


    @Override
    public List<UserDTO> getUserByFieldsByManager(String email, String keyword, String roleId) {
        Session session = sessionFactory.openSession();
        String query = "select u from User u where u.role.id not in('ROLE01','ROLE02') ";
        if (!"".equals(email)) {
            query += " and u.email = '" + email + "' ";
        }
        if (!"".equals(keyword)) {
            query += " and concat(u.email,'',u.firstName,'',u.lastName,'',u.role.name,'',u.studio.name) like '%" + keyword + "%' ";
        }

        if (!"All".equals(roleId)) {
            query += " and u.role.id = '" + roleId + "' ";
        }

        Query<User> query1 = session.createQuery(query, User.class);
        return modelMapperConfiguration.mapList(query1.getResultList(), UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserByFieldsByAssistant(String email, String keyword, String roleId) {
        Session session = sessionFactory.openSession();
        String query = "select u from User u where u.role.id not in('ROLE01','ROLE02','ROLE03') ";
        if (!"".equals(email)) {
            query += " and u.email = '" + email + "' ";
        }
        if (!"".equals(keyword)) {
            query += " and concat(u.email,'',u.firstName,'',u.lastName,'',u.role.name,'',u.studio.name) like '%" + keyword + "%' ";
        }

        if (!"All".equals(roleId)) {
            query += " and u.role.id = '" + roleId + "' ";
        }

        Query<User> query1 = session.createQuery(query, User.class);
        return modelMapperConfiguration.mapList(query1.getResultList(), UserDTO.class);
    }


    @Override
    public User getManagerOfStudio(String id) {
        return userRepository.getManagerOfStudio(id);
    }

//    @Override
//    public void changeStatusChangeSt(String email, String studioId) {
//        User user = userRepository.getUserByEmail(email);
//        user.setStatusChangeSt(1);
//        user.setStudioSt(studioId);
//        userRepository.save(user);
//    }


//
//    @Override
//    public void rejectChangeSt(UserDTO userDTO) {
//        User user = userRepository.getUserByEmail(userDTO.getEmail());
//        user.setStatusChangeSt(0);
//        user.setStudioSt("");
//        userRepository.save(user);
//    }

//    @Override
//    public void changeSt(UserDTO userDTO) {
//        User user = userRepository.getUserByEmail(userDTO.getEmail());
//        user.setStatusChangeSt(1);
//        user.setStudioSt(userDTO.getStudioSt());
//         userRepository.save(user);
//    }

    public User getUserById(Long id) {
        return userRepository.findUsersById(id);
    }



}


