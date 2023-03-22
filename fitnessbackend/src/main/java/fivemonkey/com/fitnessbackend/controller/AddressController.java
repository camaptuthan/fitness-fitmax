package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.StudioDTO;
import fivemonkey.com.fitnessbackend.service.service.AddressService;
import fivemonkey.com.fitnessbackend.service.service.StudioService;
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
    private StudioService studioService;

    @ResponseBody
    @GetMapping("/city")
    public List<CityDTO> getCities() {
        return addressService.getCities();
    }


    @ResponseBody
    @GetMapping("/studio/{city}")

    public List<StudioDTO> getStudioByCityId(@PathVariable("city") String cityName) {
        return addressService.getStudioByCity(cityName);

//        public List<StudioDTO> getStudioByCity (@PathVariable("city") String cityname){
//            return studioService.getAllStudiosByCity(cityname);
//
//        }

    }
}
