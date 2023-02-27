package fivemonkey.com.fitnessbackend.services;

import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.entities.Services;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
}
