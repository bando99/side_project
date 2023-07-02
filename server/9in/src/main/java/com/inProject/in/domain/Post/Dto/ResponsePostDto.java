package com.inProject.in.domain.Post.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponsePostDto {
    private Long id;
    private String username;
    private String type;
    private String title;
    private String text;
    private int comment_cnt;
    private List<ApplicantPostRelation> applicantPostRelationList;
    private List<Comment> commentList;
    private List<TagPostRelation> tagPostRelationList;
    private List<ClipPostRelation> clipPostRelationList;
    private List<RolePostRelation> rolePostRelationList;
}
