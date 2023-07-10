package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.service.Impl;

import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.Dto.ResponseApplicantPostDto;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.service.ApplicantPostRelationService;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository.ApplicantPostRelationRepository;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.Dto.ResponseClipPostRelationDto;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.Dto.PostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicantPostRelationServiceImpl implements ApplicantPostRelationService {

//    private UserRepository userRepository;
//    private PostRepository postRepository;
//    private ApplicantPostRelationRepository applicantPostRelationRepository;
//    private final Logger log = LoggerFactory.getLogger(ApplicantPostRelationServiceImpl.class);
//    @Autowired
//    public ApplicantPostRelationServiceImpl(UserRepository userRepository,
//                                            PostRepository postRepository,
//                                            ApplicantPostRelationRepository applicantPostRelationRepository) {
//
//        this.userRepository = userRepository;
//        this.postRepository = postRepository;
//        this.applicantPostRelationRepository = applicantPostRelationRepository;
//    }
//    @Override
//    public ResponseApplicantPostDto insertApplicantPost(Long user_id, Long post_id) {
//
//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("insert applicant - post 에서 유효하지 않은 user id : " + user_id));
//
//        Post post = postRepository.findById(post_id)
//                .orElseThrow(() -> new IllegalArgumentException("insert applicant - post 에서 유효하지 않은 post id : " + post_id));
//
//        log.info("Using insertApplicantPost in applicant - post Service ==> post_id : " + post_id + " user_id : " + user_id);
//
//        //유저가 그 게시글에 지원했었는 지 확인.
//        if(applicantPostRelationRepository.isExistApplicantPost(user, post) == false) {
//
//            ApplicantPostRelation applicantPostRelation = ApplicantPostRelation.builder()
//                    .post_applicant(user)
//                    .post(post)
//                    .build();
//
//            ApplicantPostRelation createApplicantPostRelation = applicantPostRelationRepository.save(applicantPostRelation);
//            ResponseApplicantPostDto responseApplicantPostDto = new ResponseApplicantPostDto(createApplicantPostRelation);
//
//            log.info("Insert Applicant Post Relation ==> relation_id " + responseApplicantPostDto.getId());
//
//            return responseApplicantPostDto;
//        }
//
//        return null;  //유저가 누른 적 있는 경우 null.
//
//    }
//
//    @Override
//    public ResponseApplicantPostDto deleteApplicantPost(Long user_id, Long post_id) {
//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - post 에서 유효하지 않은 user id : " + user_id));
//
//        Post post = postRepository.findById(post_id)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - post 에서 유효하지 않은 post id : " + post_id));
//
//        ApplicantPostRelation applicantPostRelation = applicantPostRelationRepository.findApplicantPost(user, post)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - post에서 찾을 수 없는 relation ==> user id : " + user_id
//                 + " post id : " + post_id));
//
//        log.info("Using delete applicant post in service ==> post_id " + post_id + " user_id " + user_id);
//        log.info("delete Applicant Post Relation ==> relation_id " + applicantPostRelation.getId());
//
//        applicantPostRelationRepository.delete(applicantPostRelation);
//        return null;
//
//    }
}
