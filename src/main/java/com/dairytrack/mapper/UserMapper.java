package com.dairytrack.mapper;

import com.dairytrack.dto.SignUpRequestDto;
import com.dairytrack.dto.UserDto;
import com.dairytrack.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User fromSignUp(SignUpRequestDto req);
}
