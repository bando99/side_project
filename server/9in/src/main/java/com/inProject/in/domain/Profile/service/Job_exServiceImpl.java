package com.inProject.in.domain.Profile.service;

import com.inProject.in.domain.Profile.Dto.RequestJob_exDto;
import com.inProject.in.domain.Profile.Dto.ResponseJob_exDto;
import com.inProject.in.domain.Profile.entity.Job_ex;
import com.inProject.in.domain.Profile.repository.Job_exRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Job_exServiceImpl {
    private UserRepository userRepository;
    private Job_exRepository job_exRepository;

    @Autowired
    public Job_exServiceImpl(UserRepository userRepository,
                                  Job_exRepository job_exRepository){
        this.userRepository = userRepository;
        this.job_exRepository = job_exRepository;
    }

    public ResponseJob_exDto getJob_ex(Long user_id){
        Job_ex job_ex = job_exRepository.findJob_exByUserId(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Job_exService getJob_ex 에서 유효하지 않은 user id : " + user_id));

        ResponseJob_exDto responseJob_exDto = new ResponseJob_exDto(job_ex);
        return responseJob_exDto;
    }

    public ResponseJob_exDto createJob_ex(RequestJob_exDto requestJob_exDto){
        Long user_id = requestJob_exDto.getUser_id();
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Job_exService getJob_ex 에서 유효하지 않은 user id : " + user_id));

        Job_ex job_ex = requestJob_exDto.toEntity(user);

        Job_ex savedJob_ex = job_exRepository.save(job_ex);

        ResponseJob_exDto responseJob_exDto = new ResponseJob_exDto(savedJob_ex);

        return responseJob_exDto;
    }

    public ResponseJob_exDto updateJob_ex(RequestJob_exDto requestJob_exDto){
        Long user_id = requestJob_exDto.getUser_id();

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Job_exService getJob_ex 에서 유효하지 않은 user id : " + user_id));

        Job_ex job_ex = requestJob_exDto.toEntity(user);

        Job_ex updatedJob_ex = job_exRepository.save(job_ex);

        ResponseJob_exDto responseJob_exDto = new ResponseJob_exDto(updatedJob_ex);

        return responseJob_exDto;
    }

    public void deleteJob_ex(Long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Job_exService getJob_ex 에서 유효하지 않은 user id : " + user_id));

        job_exRepository.deleteById(user.getJobEx().getId());
    }
}
