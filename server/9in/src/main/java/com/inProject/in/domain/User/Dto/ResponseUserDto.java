package com.inProject.in.domain.User.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.Dto.ResponsePostDto;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseUserDto {

    private Long id;
    private String username;
    private String mail;
    private List<Post> authoredPostList;
    private List<ApplicantPostRelation> applicantPostRelationList;
    private List<ApplicantRoleRelation> applicantRoleRelationList;
    private List<ClipPostRelation> clipPostRelationList;
    private List<Comment> commentList;

    public ResponseUserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.mail = user.getMail();
        this.authoredPostList = user.getAuthoredPostList();
        this.applicantPostRelationList = user.getApplicantPostRelationList();
        this.applicantRoleRelationList = user.getApplicantRoleRelationList();
        this.clipPostRelationList = user.getClipPostRelationList();
        this.commentList = user.getCommentList();
    }
}
