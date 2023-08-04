package com.inProject.in.domain.User.controller;

import com.inProject.in.domain.User.Dto.ResponseUserDto;
import com.inProject.in.domain.User.Dto.UpdateUserDto;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody UserDto userDto){

        ResponseUserDto responseUserDto = userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseUserDto);
    }

    @PatchMapping("/{user_id}")
    public ResponseEntity<ResponseUserDto> updateUser(@PathVariable Long user_id,
                                                      @RequestBody UpdateUserDto updateUserDto) {

        ResponseUserDto responseUserDto = userService.updateUser(user_id, updateUserDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseUserDto);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long user_id){

        userService.deleteUser(user_id);

        return ResponseEntity.status(HttpStatus.OK).body("유저 삭제 완료");
    }
}
