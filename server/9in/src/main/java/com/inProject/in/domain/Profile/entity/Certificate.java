package com.inProject.in.domain.Profile.entity;

import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Profile.Dto.request.RequestCertificateDto;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicUpdate
@Table(name = "certificate")
public class Certificate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String certificate_name;  //자격증 이름
    @Column
    private LocalDate acquisition_date; //딴 날짜
    @Column
    private String link;
    @Column
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    public void updateCertificate(RequestCertificateDto requestCertificateDto){
        this.certificate_name = requestCertificateDto.getCertificate_name();
        this.acquisition_date = requestCertificateDto.getAcquisition_date();
        this.link = requestCertificateDto.getLink();
        this.explanation = requestCertificateDto.getExplanation();
    }
}
