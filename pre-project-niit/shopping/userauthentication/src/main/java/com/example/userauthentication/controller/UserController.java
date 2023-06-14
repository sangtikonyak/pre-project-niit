package com.example.userauthentication.controller;

import com.example.userauthentication.entity.User;
import com.example.userauthentication.entity.UserSignUp;
import com.example.userauthentication.exceptions.InvalidCredentialException;
import com.example.userauthentication.exceptions.UserAlreadyExistException;
import com.example.userauthentication.security.SecurityTokenGenerator;
import com.example.userauthentication.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final SecurityTokenGenerator securityTokenGenerator;
    private final UserServiceInterface userServiceInterface;

    private ResponseEntity<?> responseEntity;

    @Autowired
    public UserController(SecurityTokenGenerator securityTokenGenerator, UserServiceInterface userServiceInterface) {
        this.securityTokenGenerator = securityTokenGenerator;
        this.userServiceInterface = userServiceInterface;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUp userSignUp) throws UserAlreadyExistException {
//        try {
//            userServiceInterface.signUp(user);
//            responseEntity=new ResponseEntity<>("signIn successfully", HttpStatus.CREATED);
//        } catch (UserAlreadyExistException e) {
//            throw new UserAlreadyExistException();
//        }catch (Exception e){
//            responseEntity=new ResponseEntity<>("internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return responseEntity;
        return new ResponseEntity<>(userServiceInterface.signUp(userSignUp),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentialException {
//        try {
//            userServiceInterface.login(user);
//            Map<String,String> token = securityTokenGenerator.generateToken(user);
//            responseEntity=new ResponseEntity<>(token,HttpStatus.OK);
//        }catch (InvalidCredentialException e){
//            throw new InvalidCredentialException();
//        }catch (Exception e){
//            responseEntity=new ResponseEntity<>("internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        User userFromDb=userServiceInterface.login(user);
        System.out.println("user from db"+ userFromDb);
    return new ResponseEntity<>(securityTokenGenerator.generateToken(userFromDb),HttpStatus.OK);
 }
}
