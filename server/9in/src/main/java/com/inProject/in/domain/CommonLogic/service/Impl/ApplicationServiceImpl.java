package com.inProject.in.domain.CommonLogic.service.Impl;

import com.inProject.in.domain.CommonLogic.Dto.ResponseApplicationDto;
import com.inProject.in.domain.CommonLogic.service.ApplicationService;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.repository.ApplicantPostRelationRepository;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.repository.ApplicantRoleRelationRepository;
import com.inProject.in.domain.MToNRelation.RolePostRelation.Dto.RolePostRelationDto;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.repository.RolePostRelationRepository;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.Post.repository.PostRepository;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.BeanDefinitionDsl;

public class ApplicationServiceImpl implements ApplicationService {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private RoleNeededRepository roleNeededRepository;
    private ApplicantPostRelationRepository applicantPostRelationRepository;
    private ApplicantRoleRelationRepository applicantRoleRelationRepository;
    private RolePostRelationRepository rolePostRelationRepository;
    private final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);
    public ApplicationServiceImpl(UserRepository userRepository,
                                  PostRepository postRepository,
                                  RoleNeededRepository roleNeededRepository,
                                  ApplicantPostRelationRepository applicantPostRelationRepository,
                                  ApplicantRoleRelationRepository applicantRoleRelationRepository,
                                  RolePostRelationRepository rolePostRelationRepository){

        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.roleNeededRepository = roleNeededRepository;
        this.applicantPostRelationRepository = applicantPostRelationRepository;
        this.applicantRoleRelationRepository = applicantRoleRelationRepository;
        this.rolePostRelationRepository = rolePostRelationRepository;
    }


    @Override
    public ResponseApplicationDto applyToPost(Long user_id, Long post_id, Long role_id) {  //사용자가 지원 버튼 눌렀을 때 로직

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("insert applicant 에서 유효하지 않은 user id : " + user_id));

        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new IllegalArgumentException("insert applicant 에서 유효하지 않은 post id : " + post_id));

        RoleNeeded roleNeeded = roleNeededRepository.findById(role_id)
                .orElseThrow(() -> new IllegalArgumentException("insert applicant 에서 유효하지 않은 role id : " + role_id));

        if(applicantPostRelationRepository.isExistApplicantPost(user, post) == false) {  //이미 지원한 게시글에는 지원 불가

            ApplicantPostRelation applicantPostRelation = ApplicantPostRelation.builder()
                    .post_applicant(user)
                    .post(post)
                    .build();

            ApplicantRoleRelation applicantRoleRelation = ApplicantRoleRelation.builder()
                    .role_applicant(user)
                    .roleNeeded(roleNeeded)
                    .build();

            RolePostRelation rolePostRelation = rolePostRelationRepository.findRelationByRoleId(post_id, role_id).get();   //Optional 처리 생각

            int pre_cnt = rolePostRelation.getPre_cnt();
            int want_cnt = rolePostRelation.getWant_cnt();

            if(pre_cnt < want_cnt){
                rolePostRelation.setPre_cnt(pre_cnt + 1);
                RolePostRelation updateRolePost = rolePostRelationRepository.save(rolePostRelation);
                log.info("Update role - post relation ==> role - post relation_id : " + updateRolePost.getId() +
                        " relation pre_cnt : " + updateRolePost.getPre_cnt() + " relation want_cnt : " + updateRolePost.getWant_cnt());
            }
            else{
                //초과 시 로직.
            }

            ApplicantPostRelation createApplicantPostRelation = applicantPostRelationRepository.save(applicantPostRelation);
            ApplicantRoleRelation createApplicantRoleRelation = applicantRoleRelationRepository.save(applicantRoleRelation);

            log.info("Insert application ==> user - post relation_id : " + createApplicantPostRelation.getId() +
                    " user - role relation_id : " + createApplicantRoleRelation.getId());

            return null;      //필요한 정보 추후에 반환할 것 정하고 dto로 작성할 것.
        }
        return null;
    }
}
