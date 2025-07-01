package com.weratework.weratework.controller;

import com.weratework.weratework.model.Role;
import com.weratework.weratework.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // return all categories
    @GetMapping
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    // send a new category
    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleRepository.save(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roleRepository.deleteById(id);
    }

}
