package com.cycleofLife.cycleofLife.service;

import com.cycleofLife.cycleofLife.api.model.RegistrationBody;
import com.cycleofLife.cycleofLife.entity.Users;
import com.cycleofLife.cycleofLife.entity.dao.UserDAO;
import com.cycleofLife.cycleofLife.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Users registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException {
        if(userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistException();
        }
        Users user = new Users();
        user.setUsername(registrationBody.getUsername());
        user.setEmail(registrationBody.getEmail());
        //TODO : Encrypt Password
        user.setPassword(registrationBody.getPassword());
        return userDAO.save(user);
    }
}
