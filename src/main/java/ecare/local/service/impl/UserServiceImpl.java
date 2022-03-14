package ecare.local.service.impl;

import ecare.local.dao.UserDAO;
import ecare.local.dto.UserDTO;
import ecare.local.model.User;
import ecare.local.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDao;

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User addUser(UserDTO userDto){
        return userDao.save(userDto.asEntity());
    }
}
