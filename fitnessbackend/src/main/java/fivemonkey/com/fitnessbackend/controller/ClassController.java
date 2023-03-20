package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.ClassService;
import fivemonkey.com.fitnessbackend.service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("{service_id}")
    public String getDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("service_id") String id, Model model) {


        ClassDTO classDTO = classService.getByServiceId(id);
        List<ClassDTO> classDTOList = classService.getAll();

        Map<String, List<ClassDTO>> classDTOListMap = new HashMap<>();

        for (int i = 0; i < (classDTOList.size() / 3) + 1; i++) {
            List<ClassDTO> valueList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i * 3 + j < classDTOList.size()) {
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
}
