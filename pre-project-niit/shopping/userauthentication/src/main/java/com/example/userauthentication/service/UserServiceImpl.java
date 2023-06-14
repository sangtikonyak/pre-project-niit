package com.example.userauthentication.service;

import com.example.userauthentication.entity.User;
import com.example.userauthentication.entity.UserDTO;
import com.example.userauthentication.entity.UserSignUp;
import com.example.userauthentication.exceptions.InvalidCredentialException;
import com.example.userauthentication.exceptions.UserAlreadyExistException;
import com.example.userauthentication.proxy.UserProductProxy;
import com.example.userauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface  {

    private UserRepository userRepository;

    private UserProductProxy userProductProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProductProxy userProductProxy) {
        this.userRepository = userRepository;
        this.userProductProxy = userProductProxy;
    }

    @Override
    public User signUp(UserSignUp user) throws UserAlreadyExistException  {
        if (userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }
        UserDTO userDTO=new UserDTO();
        if (!user.getEmail().isEmpty()){
            userDTO.setEmail(user.getEmail());
            userDTO.setUserName(user.getUserName());
            ResponseEntity responseEntity=userProductProxy.saveUser(userDTO);
            System.out.println(responseEntity.getBody());
        }
        User user1=new User(user.getEmail(),user.getPassword(),"ROLE_USER");
        return userRepository.save(user1);
    }

    @Override
    public User login(User user) throws InvalidCredentialException {
        User userFromDb=userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (userFromDb == null)
        {
            throw new InvalidCredentialException();
        }
        return userFromDb;
    }
}
