package com.example.demo.controllers;

import com.example.demo.models.UsersRoles;
import com.example.demo.services.UsersRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/views/usersrolesview")
public class UsersRolesController {

    private UsersRolesService usersRolesService;

    @Autowired
    public UsersRolesController(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    @GetMapping
    public List<UsersRoles> getAllUsersRoles(){
        return usersRolesService.getAllUsersRoles();
    }
}
