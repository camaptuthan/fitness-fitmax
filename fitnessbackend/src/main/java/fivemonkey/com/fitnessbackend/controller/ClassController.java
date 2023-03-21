package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.ClassService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import fivemonkey.com.fitnessbackend.service.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class")
public class ClassController {


    @Autowired
    private ClassService classService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("{service_id}")
    public String getDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("service_id") String id, Model model) {


        ClassDTO classDTO = classService.getByServiceId(id);
        List<ClassDTO> classDTOList = classService.getAll();

        Map<String, List<ClassDTO>> classDTOListMap = new HashMap<>();

        int size = classDTOList.size() % 3 == 0 ? classDTOList.size() / 3 : classDTOList.size() / 3 + 1;
        for (int i = 0; i < size; i++) {
            List<ClassDTO> valueList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < size) {
                    valueList.add(classDTOList.get(i * 3 + j));
                }
            }
            classDTOListMap.put("page-" + i + 1, valueList);
        }


        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(classDTO.getServicesId(), userDetail.getUser().getEmail());
        }

        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("related_class", classDTOListMap);
        model.addAttribute("class", classDTO);


        return "class/profile";
    }

    @GetMapping("/management/classes")
    public String classes(Model model, @AuthenticationPrincipal UserDetail userDetail) {
        model.addAttribute("list", classService.getByUserRole(userDetail.getUser()));
        return "management/ClassManagement/classlist";
    }

    @ResponseBody
    @PostMapping(path = "/management/update")
    public ClassDTO updateClasses(@AuthenticationPrincipal UserDetail userDetail, @RequestBody ClassDTO classDTO) {
        System.out.println(classDTO);
        return classService.save(classDTO, userDetail.getUser());
    }

    @ResponseBody
    @PostMapping(path = "/management/update/session")
    public SessionDTO updateSessions(@RequestBody SessionDTO sessionDTO) {
        return sessionService.save(sessionDTO);
    }


}
