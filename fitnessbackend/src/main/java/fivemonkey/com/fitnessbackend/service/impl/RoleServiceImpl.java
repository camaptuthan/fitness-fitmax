package fivemonkey.com.fitnessbackend.service.impl;

import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.repository.RoleRepository;
import fivemonkey.com.fitnessbackend.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return  roleRepository.findAll();
    }

    @Override
    public List<Role> getRoleAdmin() {
        return roleRepository.getRoleAdmin();
    }

    @Override
    public List<Role> getRoleManager() {
        return roleRepository.getRoleManager();
    }

    @Override
    public List<Role> getRoleAssistant() {
        return roleRepository.getRoleAssistant();
    }
}
