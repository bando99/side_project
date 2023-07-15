package com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.service.Impl;

import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.service.ApplicantRoleRelationService;

public class ApplicantRoleRelationServiceImpl implements ApplicantRoleRelationService {

//    private UserRepository userRepository;
//    private RoleNeededRepository roleNeededRepository;
//    private ApplicantRoleRelationRepository applicantRoleRelationRepository;
//
//    private final Logger log = LoggerFactory.getLogger(ApplicantPostRelationServiceImpl.class);
//
//    @Autowired
//    public ApplicantRoleRelationServiceImpl(UserRepository userRepository,
//                                            RoleNeededRepository roleNeededRepository,
//                                            ApplicantRoleRelationRepository applicantRoleRelationRepository){
//        this.userRepository = userRepository;
//        this.roleNeededRepository = roleNeededRepository;
//        this.applicantRoleRelationRepository = applicantRoleRelationRepository;
//    }
//
//    @Override
//    public ResponseApplicantRoleDto insertApplicantRole(Long user_id, Long role_id) {
//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("insert applicant - role 에서 유효하지 않은 user id : " + user_id));
//
//        RoleNeeded roleNeeded = roleNeededRepository.findById(role_id)
//                        .orElseThrow(() -> new IllegalArgumentException("insert applicant - role 에서 유효하지 않은 role id : " + role_id));
//
//        log.info("Using insertApplicantPost in applicant - role Service ==> post_id : " + role_id + " user_id : " + user_id);
//
//        //유저가 그 게시글에 지원했었는 지 확인.
//        if(applicantRoleRelationRepository.isExistApplicantRole(user, roleNeeded) == false) {
//
//            ApplicantRoleRelation applicantRoleRelation = ApplicantRoleRelation.builder()
//                    .role_applicant(user)
//                    .roleNeeded(roleNeeded)
//                    .build();
//
//            ApplicantRoleRelation createApplicantRoleRelation = applicantRoleRelationRepository.save(applicantRoleRelation);
//            ResponseApplicantRoleDto responseApplicantRoleDto = new ResponseApplicantRoleDto(createApplicantRoleRelation);
//
//            log.info("Insert Applicant Role Relation ==> relation_id " + responseApplicantRoleDto.getId());
//
//            return responseApplicantRoleDto;
//        }
//
//        return null;  //유저가 누른 적 있는 경우 null.
//
//    }
//
//    @Override
//    public ResponseApplicantRoleDto deleteApplicantRole(Long user_id, Long role_id) {
//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - role 에서 유효하지 않은 user id : " + user_id));
//
//        RoleNeeded roleNeeded = roleNeededRepository.findById(role_id)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - role 에서 유효하지 않은 role id : " + role_id));
//
//        ApplicantRoleRelation applicantRoleRelation = applicantRoleRelationRepository.findApplicantRole(user, roleNeeded)
//                .orElseThrow(() -> new IllegalArgumentException("delete applicant - role에서 찾을 수 없는 relation ==> user id : " + user_id
//                        + " role id : " + role_id));
//
//        log.info("Using delete applicant role in service ==> role_id " + role_id + " user_id " + user_id);
//        log.info("delete Applicant Role Relation ==> relation_id " + applicantRoleRelation.getId());
//
//        applicantRoleRelationRepository.delete(applicantRoleRelation);
//        return null;
//    }
}
