package com.inProject.in.domain.Post.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponsePostDto {
    private Long id;
    private String type;
    private String title;
    private String text;
    private String proceed_method;
    private LocalDateTime period;
    private int comment_cnt;
    private User author;
    private List<ApplicantPostRelation> applicantPostRelationList;
    private List<Comment> commentList;
    private List<TagPostRelation> tagPostRelationList;
    private List<ClipPostRelation> clipPostRelationList;
    private List<RolePostRelation> rolePostRelationList;

    public ResponsePostDto(Post post){
        this.id = post.getId();
        this.type = post.getType();
        this.text = post.getText();
        this.title = post.getTitle();
        this.proceed_method = post.getProceed_method();
        this.period = post.getPeriod();
        this.comment_cnt = post.getComment_cnt();
        this.author = post.getAuthor();
        this.applicantPostRelationList = post.getApplicantPostRelationList();
        this.commentList = post.getCommentList();
        this.tagPostRelationList = post.getTagPostRelationList();
        this.clipPostRelationList = post.getClipPostRelationList();
        this.rolePostRelationList = post.getRolePostRelationList();
    }
}
