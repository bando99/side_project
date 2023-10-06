package com.inProject.in.domain.Profile.service;

import com.inProject.in.Global.exception.ConstantsClass;
import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.Profile.Dto.request.RequestCertificateDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseCertificateDto;
import com.inProject.in.domain.Profile.entity.Certificate;
import com.inProject.in.domain.Profile.repository.CertificateRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CertificateServiceImpl {
    private UserRepository userRepository;
    private CertificateRepository certificateRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final Logger log = LoggerFactory.getLogger(CertificateServiceImpl.class);
    @Autowired
    public CertificateServiceImpl(UserRepository userRepository,
                                  CertificateRepository certificateRepository,
                                  JwtTokenProvider jwtTokenProvider){
        this.userRepository = userRepository;
        this.certificateRepository = certificateRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public ResponseCertificateDto getCertificate(Long user_id){

        Certificate certificate = certificateRepository.findCertificateByUserId(user_id)
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user_id + "는 certificate를 생성하지 않았음."));

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(certificate);

        log.info("CertificateService getCertificate ==> user id : " + user_id + " 자격증 정보 : " + certificate.getCertificate_name());
        return responseCertificateDto;
    }
    @Transactional
    public ResponseCertificateDto createCertificate(RequestCertificateDto requestCertificateDto, HttpServletRequest request){
        User user = getUserFromRequest(request);

        Certificate certificate = requestCertificateDto.toEntity(user);
        Certificate savedCertificate = certificateRepository.save(certificate);
        user.setCertificate(savedCertificate);

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(savedCertificate);

        log.info("CertificateService createCertificate ==> username : " + user.getUsername() + " 자격증 이름 : " + savedCertificate.getCertificate_name());
        return responseCertificateDto;
    }

    @Transactional
    public ResponseCertificateDto updateCertificate(RequestCertificateDto requestCertificateDto, HttpServletRequest request){
        User user = getUserFromRequest(request);

        Certificate certificate = certificateRepository.findCertificateByUserId(user.getId())
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user.getId() + "는 certificate를 생성하지 않았음." ));

        if(!certificate.getUser().getId().equals(user.getId())){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.UNAUTHORIZED, user.getId() + "은 프로필 작성자가 아닙니다.");
        }

        log.info("CertificateService updateCertificate ==> 업데이트 전 : " + certificate.toString());
        certificate.updateCertificate(requestCertificateDto);
        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(certificate);

        log.info("CertificateService updateCertificate ==> 업데이트 후 + " + certificate.toString());
        return responseCertificateDto;
    }
    @Transactional
    public void deleteCertificate(HttpServletRequest request){
        User user = getUserFromRequest(request);

        Certificate certificate = certificateRepository.findCertificateByUserId(user.getId())
                        .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user.getId() + "는 certificate를 생성하지 않았음." ));

        if(!certificate.getUser().getId().equals(user.getId())){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.UNAUTHORIZED, user.getId() + "은 프로필 작성자가 아닙니다.");
        }

        certificateRepository.deleteById(user.getCertificate().getId());
        log.info("CertificateService deleteCertificate ==> 삭제 완료");
    }

    private User getUserFromRequest(HttpServletRequest request){
        String token = jwtTokenProvider.resolveToken(request);
        User user;

        if(token != null && jwtTokenProvider.validateToken(token)){
            String username = jwtTokenProvider.getUsername(token);

            return user = userRepository.getByUsername(username)
                    .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "BoardService ==> request로부터 user를 찾지 못함"));
        }
        else{
            throw new CustomException(ConstantsClass.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "token이 없거나, 권한이 유효하지 않습니다.");
        }


    }
}
