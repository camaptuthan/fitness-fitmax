package fivemonkey.com.fitnessbackend.service;
import fivemonkey.com.fitnessbackend.entities.Role;
import fivemonkey.com.fitnessbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAll() {
        return  roleRepository.findAll();
    }


    public List<Role> getRoleAdmin() {
        return roleRepository.getRoleAdmin();
    }


    public List<Role> getRoleManager() {
        return roleRepository.getRoleManager();
    }


    public List<Role> getRoleAssistant() {
        return roleRepository.getRoleAssistant();
    }
}
