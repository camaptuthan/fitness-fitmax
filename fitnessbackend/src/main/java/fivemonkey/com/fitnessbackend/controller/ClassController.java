package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.imageuploader.ImageUploader;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private ServicesService servicesService;
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ImageUploader imageUploader;

    @GetMapping("{service_id}")
    public String getDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("service_id") String id, Model model) {


        ClassDTO classDTO = classService.getByServiceId(id);
        List<ClassDTO> classDTOList = classService.getAll();

        Map<String, List<ClassDTO>> classDTOListMap = new HashMap<>();

        int size = classDTOList.size() % 3 == 0 ? classDTOList.size() / 3 : (classDTOList.size() / 3) + 1;
        for (int i = 0; i < size; i++) {
            List<ClassDTO> valueList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                valueList.add(classDTOList.get(i * 3 + j));
            }
            classDTOListMap.put("page-" + (i + 1), valueList);
        }

        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(classDTO.getServicesId(), userDetail.getUser().getEmail());
        }

        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("related_class", classDTOListMap);
        model.addAttribute("class", classDTO);

        return "user/class-detail";
    }

    @GetMapping("/management/classes")
    public String classes(Model model, @AuthenticationPrincipal UserDetail userDetail, @RequestParam(value = "page", defaultValue = "1") int page) {
        String path = "management/ClassManagement/classlist";

        int pageSize = 6;
        int currentPage = page < 1 ? 1 : page >= pageSize ? pageSize - 1 : page;
        List<ClassDTO> classDTOList = classService.getByUserRole(userDetail.getUser(), currentPage, pageSize);
        model.addAttribute("currentPage", currentPage);
        int totalPage = classService.getByUserRole(userDetail.getUser(), 0, 0).size() / pageSize == 0 ? 1 : classService.getByUserRole(userDetail.getUser(), 0, 0).size() / pageSize;
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("list", classDTOList);
        return path;
    }

    @GetMapping("/management/classes/{id}")
    public String classes(Model model,
                          @AuthenticationPrincipal UserDetail userDetail,
                          @PathVariable("id") String serviceId) {
        String path = "management/ClassManagement/class";
        ClassDTO foundClass = serviceId.equals("new") ? new ClassDTO() : classService.getByServiceId(serviceId);
 
        if (foundClass.getId() != null && classService.getByUserRole(userDetail.getUser(), 0, 0).stream().noneMatch(o -> o.getId().equals(foundClass.getId()))) {
 
            path = "redirect:/service/class/management/classes";
        } else {
            model.addAttribute("trainers", trainerService.getAllAvailableTrainersByStudio(foundClass.getServicesStudioId()));
            model.addAttribute("cities", addressService.getCities());
 
            model.addAttribute("studios", addressService.getStudioByCity(serviceId.equals("new") ? userDetail.getUser().getRole().getId().equalsIgnoreCase("role01") ? "Ha Noi" : userDetail.getUser().getCity().getName() : foundClass.getServicesCityName()));
            model.addAttribute("schedules", scheduleService.getAll(null, null));
            model.addAttribute("item", foundClass);
        }
        return path;
    }

    @ResponseBody
    @PostMapping("/management/api/update/{id}")
    public ClassDTO updateClasses(@PathVariable("id") String serviceId,
                                  @RequestParam(value = "fileImage", defaultValue = "", required = false) MultipartFile multipartFile,
                                  Model model) throws IOException {
        return classService.saveThumbnail(imageUploader.upload(multipartFile), serviceId);
    }

    @ResponseBody
    @PostMapping(path = "/management/api/update")
    public ClassDTO updateClasses(@AuthenticationPrincipal UserDetail userDetail, @RequestBody ClassDTO classDTO) {
        return classService.save(classDTO, userDetail.getUser());
    }

    @ResponseBody
    @PostMapping(path = "/management/api/update/session")
    public SessionDTO updateSessions(@RequestBody SessionDTO sessionDTO) {
        return sessionService.save(sessionDTO);
    }


}
