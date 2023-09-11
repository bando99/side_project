package com.inProject.in.domain.RoleNeeded.service;

import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;

import java.util.List;

public interface RoleNeededService {
    ResponseRoleNeededDto getRoleNeeded(Long id);
    List<ResponseRoleNeededDto> createRoleNeededs(RequestRoleNeededDto requestRoleNeededDto);
    ResponseRoleNeededDto updateRoleNeeded(Long id, RequestRoleNeededDto requestRoleNeededDto);
    void deleteRoleNeeded(Long id);
}
