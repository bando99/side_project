package com.inProject.in.domain.RoleNeeded.service.Impl;

import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.RoleNeeded.service.RoleNeededService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
    public List<ResponseRoleNeededDto> createRoleNeededs(List<RoleNeededDto> roleNeededDtoList, Long post_id) {
        List<ResponseRoleNeededDto> responseRoleNeededDtoList = new ArrayList<>();

        for(RoleNeededDto roleNeededDto : roleNeededDtoList){
            RoleNeeded roleNeeded = RoleNeeded.builder()
                    .name(roleNeededDto.getName())
                    .build();

            RoleNeeded savedRoleNeeded = roleNeededRepository.save(roleNeeded);

            ResponseRoleNeededDto responseRoleNeededDto = ResponseRoleNeededDto.builder()
                    .name(savedRoleNeeded.getName())
                    .build();

            responseRoleNeededDtoList.add(responseRoleNeededDto);

        }
        return responseRoleNeededDtoList;
    }

    @Override
    public ResponseRoleNeededDto updateRoleNeeded(Long post_id, RoleNeededDto roleNeededDto) {

        return null;
    }

    @Override
    public void deleteRoleNeeded(Long id) {

    }
}
