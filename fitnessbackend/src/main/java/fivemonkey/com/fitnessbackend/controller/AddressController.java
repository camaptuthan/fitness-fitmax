package fivemonkey.com.fitnessbackend.controller;

import fivemonkey.com.fitnessbackend.dto.CityDTO;
import fivemonkey.com.fitnessbackend.dto.DistrictDTO;
import fivemonkey.com.fitnessbackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ResponseBody
    @GetMapping("/city")
    public List<CityDTO> getCities() {
        return addressService.getCities();
    }

    @ResponseBody
    @GetMapping("/district/{city}")
    public List<DistrictDTO> getDistrictsByCityId(@PathVariable("city") Long cityId) {
        System.out.println("Huy"+cityId);
        return addressService.getDistrictsByCityId(cityId);
    }
}
