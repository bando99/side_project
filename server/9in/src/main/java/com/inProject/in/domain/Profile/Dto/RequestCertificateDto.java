package com.inProject.in.domain.Profile.Dto;

import com.inProject.in.domain.Profile.entity.Certificate;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RequestCertificateDto {

    private String certificate_name;  //자격증 이름
    private String acquisition_date; //딴 날짜
    private String link;
    private String explanation;
    private Long user_id;

    public Certificate toEntity(User user){
        return Certificate.builder()
                .certificate_name(certificate_name)
                .acquisition_date(acquisition_date)
                .link(link)
                .explanation(explanation)
                .user(user)
                .build();
    }
}
