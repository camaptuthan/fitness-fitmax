package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.dto.ServicesDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.service.AddressService;
import fivemonkey.com.fitnessbackend.service.ServicesService;
import fivemonkey.com.fitnessbackend.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private ServicesService servicesService;

    @Autowired
    private StudioService studioService;

    @ResponseBody
    @GetMapping("/city")
    public List<CityDTO> getCities() {
        return addressService.getCities();
    }


    @ResponseBody
    @GetMapping("/district/{cityid}")
    public List<DistrictDTO> getDistricts(@PathVariable("cityid") String cityName) {
        return addressService.getDistrictsByCityName(cityName);
    }


    @ResponseBody
    @GetMapping("/studio/{city}")
    public List<StudioDTO> getStudioByCityId(@PathVariable("city") String cityName) {
        return addressService.getStudioByCity(cityName);

    }

    @ResponseBody
    @GetMapping("/services/{cityid}")
    public List<ServicesDTO> getServices(@PathVariable("cityid") String cityName) {
        return servicesService.getServicesByCity(cityName);
    }

    @ResponseBody
    @GetMapping("/studio/{serviceid}/{cityid}")
    public List<StudioDTO> getStudio(@PathVariable("serviceid") String serviceId,
                                     @PathVariable("cityid") String cityName) {
        boolean hasStudio = servicesService.findCityStudioByService(serviceId);
        if(hasStudio == false){
        return studioService.getAllByCity(cityName);
    }
        else {
            return studioService.listStudioByService(serviceId);
        }}
}
