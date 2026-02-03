package com.dairytrack.security;

import com.dairytrack.dto.UserDto;
import com.dairytrack.mapper.UserMapper;
import com.dairytrack.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDto currentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userMapper.toDto(user);
    }
}
