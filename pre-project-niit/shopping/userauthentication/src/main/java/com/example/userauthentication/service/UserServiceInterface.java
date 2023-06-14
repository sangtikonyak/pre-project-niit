package com.example.userauthentication.service;

import com.example.userauthentication.entity.User;
import com.example.userauthentication.entity.UserSignUp;
import com.example.userauthentication.exceptions.InvalidCredentialException;
import com.example.userauthentication.exceptions.UserAlreadyExistException;

public interface UserServiceInterface {
     User signUp(UserSignUp user) throws UserAlreadyExistException;
     User login(User user) throws InvalidCredentialException;
}
