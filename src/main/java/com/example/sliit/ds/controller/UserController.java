package com.example.sliit.ds.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sliit.ds.entities.User;
import com.example.sliit.ds.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
    UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public Iterable<User> user() {
        return userRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public User save(@RequestBody User user) {
    	userRepository.save(user);

        return user;
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public Optional<User> show(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        Optional<User> optcontact = userRepository.findById(id);
        User u = optcontact.get();
        if(user.getName() != null)
            u.setName(user.getName());
        if(user.getEmail() != null)
            u.setEmail(user.getEmail());
        if(user.getPassword() != null)
            u.setPassword(user.getPassword());
        userRepository.save(u);
        return u;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
    public String delete(@PathVariable String id) {
        Optional<User> optuser = userRepository.findById(id);
        User user = optuser.get();
        userRepository.delete(user);

        return "";
    }
}