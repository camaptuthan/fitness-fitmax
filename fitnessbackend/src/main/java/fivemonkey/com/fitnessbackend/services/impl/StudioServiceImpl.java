package fivemonkey.com.fitnessbackend.services.impl;

import fivemonkey.com.fitnessbackend.entities.Studio;
import fivemonkey.com.fitnessbackend.entities.User;
import fivemonkey.com.fitnessbackend.repository.StudioRepository;
import fivemonkey.com.fitnessbackend.services.RoleService;
import fivemonkey.com.fitnessbackend.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    StudioRepository studioRepository;

    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }

    @Override
    public Studio save(Studio studio) {
        return studioRepository.save(studio);

    }

}
