package com.inProject.in.domain.User.service.Impl;

import com.inProject.in.domain.User.Dto.ResponseUserDto;
import com.inProject.in.domain.User.Dto.UpdateUserDto;
import com.inProject.in.domain.User.Dto.RequestUserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import com.inProject.in.domain.User.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public ResponseUserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("getUser에서 유효하지 않은 id " + id));
        ResponseUserDto responseUserDto = new ResponseUserDto(user);

        return responseUserDto;
    }

    @Override
    public ResponseUserDto createUser(RequestUserDto userdto) {

        User user = userdto.toEntity();

        User savedUser = userRepository.save(user);
        ResponseUserDto responseUserDto = new ResponseUserDto(user);

        return responseUserDto;
    }

    @Override
    public ResponseUserDto updateUser(Long id, UpdateUserDto updateUserdto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updateUser에서 유효하지 않은 id " + id));

        user.updateUser(updateUserdto);
        User updatedUser = userRepository.save(user);

        ResponseUserDto responseUserDto = new ResponseUserDto(updatedUser);
        return responseUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("UserService loadUserByUsername ==> username : " + username);
        return userRepository.getByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("loadUserByUsername에서 username으로 user 찾지 못함"));
    }
}
