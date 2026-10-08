package in.codewithakhil.journalAppNew.controller;

import in.codewithakhil.journalAppNew.service.UserService;
import in.codewithakhil.journalAppNew.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody  User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<?> readUser(){
        return userService.readUser();
    }

    @GetMapping("/{id}")
    public Optional<?> readUserById(@PathVariable ObjectId id){
        return userService.readById(id);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser( @RequestBody User newData , @PathVariable("username")  String userName){
        User userInDB = userService.findByUserName(userName);
        if(userInDB != null){
            userInDB.setUsername(newData.getUsername());
            userInDB.setPassword(newData.getPassword());
            userService.createUser(userInDB);
        }

        return new  ResponseEntity<>(userInDB,HttpStatus.OK);

    }


}
