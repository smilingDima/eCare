package ecare.local.service;

import ecare.local.dto.UserDto;
import ecare.local.model.UserEntity;

public interface UserService {
    UserEntity findByLogin(String login);
    UserEntity addUser(UserDto userDto);
}