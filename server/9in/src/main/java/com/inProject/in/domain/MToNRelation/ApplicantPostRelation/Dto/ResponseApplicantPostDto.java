package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.Dto;

import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseApplicantPostDto {
    private Long id;
    private Post post;
    private User post_applicant;

    public ResponseApplicantPostDto(ApplicantPostRelation applicantPostRelation){
        this.id = applicantPostRelation.getId();
        this.post = applicantPostRelation.getPost();
        this.post_applicant = applicantPostRelation.getPost_applicant();
    }
}
