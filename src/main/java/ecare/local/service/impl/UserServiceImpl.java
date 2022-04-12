package ecare.local.service.impl;

import ecare.local.dao.UserDao;
import ecare.local.dto.UserDto;
import ecare.local.mapper.UserMapper;
import ecare.local.model.UserEntity;
import ecare.local.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public UserEntity findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public UserEntity addUser(UserDto userDto){
        return userDao.save(UserMapper.INSTANCE.userDtoToUserEntity(userDto));
    }
}
