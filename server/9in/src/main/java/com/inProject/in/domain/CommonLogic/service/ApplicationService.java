package com.inProject.in.domain.CommonLogic.service;

import com.inProject.in.domain.CommonLogic.Dto.ResponseApplicationDto;

public interface ApplicationService {
    ResponseApplicationDto applyToPost(Long user_id, Long post_id, Long role_id);
}
