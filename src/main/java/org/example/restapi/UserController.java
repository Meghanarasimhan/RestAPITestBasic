package org.example.restapi;

import org.example.restapi.model.User;
import org.example.restapi.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping //get all the users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}") //get the user by ID
   public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping//create the user
    public String createUser(@RequestParam String name){
        User user = new User(name);
        userRepository.save(user);
        return "user created " + name;
    }

    @PutMapping("/{id}") //update the user
    public String updateUser(@PathVariable int id, @RequestParam String name){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(name);
            userRepository.save(user);
            return "user updated " + name;
        }
        return "user not found";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
       Optional<User> optionalUser = userRepository.findById(id);
       if(optionalUser.isPresent()){
           User user = optionalUser.get();
           userRepository.delete(user);
           return "user deleted " + user.getName();
       }
        return "user not found";
    }


}
