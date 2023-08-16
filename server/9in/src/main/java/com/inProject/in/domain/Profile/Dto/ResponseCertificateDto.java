package com.inProject.in.domain.Profile.Dto;

import com.inProject.in.domain.Profile.entity.Certificate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseCertificateDto {
    private String certificate_name;  //자격증 이름
    private String acquisition_date; //딴 날짜
    private String link;
    private String explanation;
    private Long user_id;

    public ResponseCertificateDto(Certificate certificate){
        this.certificate_name = certificate.getCertificate_name();
        this.acquisition_date = certificate.getAcquisition_date();
        this.link = certificate.getLink();
        this.explanation = certificate.getExplanation();
        this.user_id = certificate.getUser().getId();
    }
}
