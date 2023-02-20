package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entitties.Class;
import fivemonkey.com.fitnessbackend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;



    public List<Class> getAll() {
        return classRepository.findAll();
    }

    public Class insertClazz(Class c) {
        return classRepository.save(c);
    }

    public void deleteClass(long id) {
        classRepository.deleteById(id);

    }

    public Class updateClass(Class c) {
        Class newClazz = classRepository.findById(c.getId()).orElse(null);
        newClazz.setDescription(c.getDescription());
        newClazz.setSlot(c.getSlot());
        newClazz.setName(c.getName());
        newClazz.setPrice(c.getPrice());
        newClazz.setDuration(c.getDuration());
        return classRepository.save(newClazz);
    }





}
