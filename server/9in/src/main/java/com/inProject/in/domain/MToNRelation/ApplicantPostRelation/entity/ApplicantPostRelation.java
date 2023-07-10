package com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity;


import com.inProject.in.Global.BaseEntity;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "applicantPostRelation")
public class ApplicantPostRelation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User post_applicant;

}
