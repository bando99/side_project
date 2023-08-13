package com.inProject.in.domain.RoleNeeded.service.Impl;

import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.RoleNeeded.service.RoleNeededService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleNeededServiceImpl implements RoleNeededService {

    private BoardRepository boardRepository;
    private RoleNeededRepository roleNeededRepository;
    @Autowired
    public RoleNeededServiceImpl(BoardRepository boardRepository, RoleNeededRepository roleNeededRepository){
        this.boardRepository = boardRepository;
        this.roleNeededRepository = roleNeededRepository;
    }

    @Override
    public ResponseRoleNeededDto getRoleNeeded(Long post_id) {

        return null;
    }

    @Override
    public List<ResponseRoleNeededDto> createRoleNeededs(RequestRoleNeededDto requestRoleNeededDto) {
        List<ResponseRoleNeededDto> responseRoleNeededDtoList = new ArrayList<>();

        for(String roleName : requestRoleNeededDto.getName()){

            RoleNeeded roleNeeded = RoleNeeded.builder()
                    .name(roleName)
                    .build();

            RoleNeeded savedRoleNeeded = roleNeededRepository.save(roleNeeded);

            ResponseRoleNeededDto responseRoleNeededDto = ResponseRoleNeededDto.builder()
                    .id(savedRoleNeeded.getId())
                    .name(savedRoleNeeded.getName())
                    .build();

            responseRoleNeededDtoList.add(responseRoleNeededDto);
        }
        return responseRoleNeededDtoList;
    }

    @Override
    public ResponseRoleNeededDto updateRoleNeeded(Long post_id, RequestRoleNeededDto requestRoleNeededDto) {

        return null;
    }

    @Override
    public void deleteRoleNeeded(Long id) {

    }
}
