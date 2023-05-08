package com.inProject.in.domain.User.service.Impl;

import com.inProject.in.domain.User.Dto.ResponseUserDto;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import com.inProject.in.domain.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public ResponseUserDto getUser(Long id) {
        User user = userRepository.findById(id).get();
        ResponseUserDto responseUserDto = new ResponseUserDto();

        responseUserDto.setId(user.getId());
        responseUserDto.setUser_id(user.getUser_id());
        responseUserDto.setMail(user.getMail());

        return responseUserDto;
    }

    @Override
    public ResponseUserDto createUser(UserDto userdto) {
        User user = User.builder()
                .user_id(userdto.getUser_id())
                .password(userdto.getPassword())
                .mail(userdto.getMail())
                .build();               //builder pattern

        //createAt, updateAt 추가 필요.

        User savedUser = userRepository.save(user);
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(savedUser.getId());
        responseUserDto.setUser_id(savedUser.getUser_id());
        responseUserDto.setMail(savedUser.getMail());

        return responseUserDto;
    }

    @Override
    public ResponseUserDto updateUser(Long id, UserDto userdto) {
        User user = userRepository.findById(id).get();   //예외처리 추가 가능.
        user.setUser_id(userdto.getUser_id());
        user.setPassword(userdto.getPassword());
        user.setMail(userdto.getMail());
        //updateAt 갱신 필요

        User updatedUser = userRepository.save(user);
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(updatedUser.getId());
        responseUserDto.setUser_id(updatedUser.getUser_id());
        responseUserDto.setMail(updatedUser.getMail());

        return responseUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
