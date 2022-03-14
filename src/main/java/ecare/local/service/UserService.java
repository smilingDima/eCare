package ecare.local.service;

import ecare.local.dao.UserDAO;
import ecare.local.dto.UserDTO;
import ecare.local.model.User;

public interface UserService {
    User findByLogin(String login);
    User addUser(UserDTO userDto);
}