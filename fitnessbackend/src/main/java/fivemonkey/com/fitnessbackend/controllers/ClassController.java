package fivemonkey.com.fitnessbackend.controllers;

import fivemonkey.com.fitnessbackend.entitties.Class;
import fivemonkey.com.fitnessbackend.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/class/")
public class ClassController {

    @Autowired
    ClassService classService;
    // get all class
    @GetMapping("/list")
    public List<Class> getAll(){
        return classService.getAll();
    }


    //  insert class
    @PostMapping("/insert")
    public Class insertClass(@RequestBody(required = false) Class c){
        return classService.insertClazz(c);
    }

    //delete class
    @DeleteMapping("/delete/{id}")
    public void deleteClass(@PathVariable long id){
        classService.deleteClass(id);
    }

    //update class
    @PutMapping("/update")
    public Class updateClass(@RequestBody Class c){
        return classService.updateClass(c);
    }


}
