package com.example.demo.services;

import com.example.demo.models.UsersRoles;
import com.example.demo.repository.UsersRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersRolesService {

    private UsersRolesRepository usersRolesRepository;

    @Autowired
    public UsersRolesService(UsersRolesRepository usersRolesRepository) {
        this.usersRolesRepository = usersRolesRepository;
    }

    public List<UsersRoles> getAllUsersRoles() {
        return usersRolesRepository.getAllUsersRoles();
    }
}
