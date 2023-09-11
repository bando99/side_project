package com.inProject.in.domain.Profile.service;

import com.inProject.in.domain.Profile.Dto.RequestCertificateDto;
import com.inProject.in.domain.Profile.Dto.ResponseCertificateDto;
import com.inProject.in.domain.Profile.entity.Certificate;
import com.inProject.in.domain.Profile.repository.CertificateRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl {
    private UserRepository userRepository;
    private CertificateRepository certificateRepository;

    @Autowired
    public CertificateServiceImpl(UserRepository userRepository,
                                  CertificateRepository certificateRepository){
        this.userRepository = userRepository;
        this.certificateRepository = certificateRepository;
    }

    public ResponseCertificateDto getCertificate(Long user_id){
        Certificate certificate = certificateRepository.findCertificateByUserId(user_id)
                .orElseThrow(() -> new IllegalArgumentException("CertificateService getCertificate 에서 유효하지 않은 user id : " + user_id));

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(certificate);
        return responseCertificateDto;
    }

    public ResponseCertificateDto createCertificate(RequestCertificateDto requestCertificateDto){
        Long user_id = requestCertificateDto.getUser_id();
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("CertificateService getCertificate 에서 유효하지 않은 user id : " + user_id));

        Certificate certificate = requestCertificateDto.toEntity(user);

        Certificate savedCertificate = certificateRepository.save(certificate);

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(savedCertificate);

        return responseCertificateDto;
    }

    public ResponseCertificateDto updateCertificate(RequestCertificateDto requestCertificateDto){
        Long user_id = requestCertificateDto.getUser_id();

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("CertificateService getCertificate 에서 유효하지 않은 user id : " + user_id));

        Certificate certificate = requestCertificateDto.toEntity(user);

        Certificate updatedCertificate = certificateRepository.save(certificate);

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(updatedCertificate);

        return responseCertificateDto;
    }

    public void deleteCertificate(Long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("CertificateService getCertificate 에서 유효하지 않은 user id : " + user_id));

        certificateRepository.deleteById(user.getCertificate().getId());
    }
}
