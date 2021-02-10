package com.example.coursemanager;

import java.util.*;
import com.example.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    static List<User> users = new ArrayList<User>(); 
    static {
        users.add(new User(1, "lichK1ng", "forLordaeron", "Arthas", "Menethil", "FACULTY"));
        users.add(new User(2, "4thaHorde", "loktarogar", "Thrall", "Warchief", "FACULTY"));
        users.add(new User(3, "bansheeQueen", "fortheforsaken", "Sylvanas", "Windrunner", "FACULTY"));
    };
    
    // CRUD
    
    // POST - Creating 
    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }
    
    // GET - Reading
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return users;
    }

    // UPDATE - Updating

    // DELETE - Deleting
    
    @DeleteMapping
    public List<User> deleteUser(@PathVariable("userId") int userId){
        User temp = null;
        for(User u : users){
            if(u.getId() == userId){
                temp = u;
            }
        }
        users.remove(temp);
        return users;
    }
    
}