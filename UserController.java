package com.example.springassessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }
    @PutMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id, @RequestBody User updatedUser){

            return userRepository.findById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }
    @DeleteMapping("/all")
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
