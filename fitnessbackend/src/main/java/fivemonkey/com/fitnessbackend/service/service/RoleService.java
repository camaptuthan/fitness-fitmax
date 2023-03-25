package fivemonkey.com.fitnessbackend.service.service;

import fivemonkey.com.fitnessbackend.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    List<Role> getRoleAdmin();

    List<Role> getRoleManager();

    List<Role> getRoleAssistant();
}
