package ecare.local.mapper;

import ecare.local.dao.UserDao;
import ecare.local.dto.UserDto;
import ecare.local.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userDaoToUserDto(UserDao userDao);
    UserEntity userDtoToUserEntity(UserDto userDto);
}
