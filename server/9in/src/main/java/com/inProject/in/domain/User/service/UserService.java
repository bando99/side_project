package com.inProject.in.domain.User.service;

import com.inProject.in.domain.User.Dto.ResponseUserDto;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;

public interface UserService {
    ResponseUserDto getUser(Long id);
    ResponseUserDto createUser(UserDto userdto);
    ResponseUserDto updateUser(Long id, UserDto userdto);
    void deleteUser(Long id);
}
