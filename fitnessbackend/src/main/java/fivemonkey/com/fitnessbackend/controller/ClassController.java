package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.ClassDTO;
import fivemonkey.com.fitnessbackend.dto.SessionDTO;
import fivemonkey.com.fitnessbackend.configuration.ImageUploader;
import fivemonkey.com.fitnessbackend.security.UserDetail;
import fivemonkey.com.fitnessbackend.service.*;
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
    private StudioService studioService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private ImageUploader imageUploader;

    @GetMapping("{service_id}")
    public String getDetail(@AuthenticationPrincipal UserDetail userDetail, @PathVariable("service_id") String id, Model model) {


        ClassDTO classDTO = classService.getByServiceId(id);
        List<ClassDTO> classDTOList = classService.getAllRelatedClass(classDTO.getServicesId());

        Map<String, List<ClassDTO>> classDTOListMap = new HashMap<>();

        int size = classDTOList.size() % 3 == 0 ? classDTOList.size() / 3 : (classDTOList.size() / 3) + 1;
        for (int i = 0; i < size; i++) {
            List<ClassDTO> valueList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j;
                if (index >= classDTOList.size()) break;
                valueList.add(classDTOList.get(index));
            }
            classDTOListMap.put("page-" + (i + 1), valueList);
        }

        boolean hasRegistered = false;
        if (userDetail != null) {
            hasRegistered = registrationService.hasRegistration(classDTO.getServicesId(), userDetail.getUser().getEmail());
            model.addAttribute("userEmail", userDetail.getUser().getEmail());
            model.addAttribute("userPhone", userDetail.getUser().getPhone());
        }

        model.addAttribute("hasRegistered", hasRegistered);
        model.addAttribute("related_class", classDTOListMap);
        model.addAttribute("class", classDTO);

        return "user/class-detail";
    }

    @GetMapping("/management/classes")
    public String classes(Model model,
                          @AuthenticationPrincipal UserDetail userDetail,
                          @RequestParam(name = "page", defaultValue = "1") int page,
                          @RequestParam(name = "cityName", defaultValue = "") String cityName,
                          @RequestParam(name = "studioId", defaultValue = "") String studioId,
                          @RequestParam(name = "status", defaultValue = "") String status) {
        String path = "management/ClassManagement/classlist";
        String[] keywords = new String[]{cityName, studioId, status};

        int currentPage = page < 1 ? 1 : page;
        List<ClassDTO> classDTOList = classService.getByUserRole(userDetail.getUser(), currentPage, keywords);
        model.addAttribute("currentPage", Math.min(currentPage, classService.getTotalPage()));
        model.addAttribute("totalPage", classService.getTotalPage());

        model.addAttribute("currentCity", cityName);
        model.addAttribute("currentStudio", studioId);
        model.addAttribute("currentStatus", status.isEmpty() ? "" : Integer.parseInt(status));

        model.addAttribute("cities", addressService.getCities());
        model.addAttribute("studios", cityName.isEmpty() ? studioService.getAllStudio() : studioService.getAllByCity(cityName));
        model.addAttribute("statuses", statusService.getStatusByClass());
        model.addAttribute("list", classDTOList);
        return path;
    }

    @GetMapping("/management/classes/{id}")
    public String classes(Model model,
                          @AuthenticationPrincipal UserDetail userDetail,
                          @PathVariable("id") String serviceId) {
        String path = "management/ClassManagement/class";
        ClassDTO foundClass = serviceId.equals("new") ? new ClassDTO() : classService.getByServiceId(serviceId);

        if (foundClass.getId() != null && classService.getByUserRole(userDetail.getUser(), 0, new String[]{}).stream().noneMatch(o -> o.getId().equals(foundClass.getId()))) {
            path = "redirect:/service/class/management/classes";
        } else {
            model.addAttribute("trainers", trainerService.getAllAvailableTrainersByStudio(foundClass.getServicesStudioId()));
            model.addAttribute("cities", addressService.getCities());

            model.addAttribute("studios", addressService.getStudioByCity(serviceId.equals("new") ? userDetail.getUser().getRole().getId().equalsIgnoreCase("role01") ? "Thanh Pho Ha Noi" : userDetail.getUser().getCity().getName() : foundClass.getServicesCityName()));
            model.addAttribute("schedules", scheduleService.getAll(null, null));
            model.addAttribute("statuses", statusService.getStatusByClass());
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
