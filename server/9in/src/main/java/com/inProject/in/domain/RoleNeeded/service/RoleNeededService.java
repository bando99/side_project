package com.inProject.in.domain.RoleNeeded.service;

import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;

import java.util.List;

public interface RoleNeededService {
    ResponseRoleNeededDto getRoleNeeded(Long id);
    List<ResponseRoleNeededDto> createRoleNeededs(List<RoleNeededDto> roleNeededDtoList, Long post_id);
    ResponseRoleNeededDto updateRoleNeeded(Long id, RoleNeededDto roleNeededDto);
    void deleteRoleNeeded(Long id);
}
