package com.inProject.in.domain.Post.Dto;

import com.inProject.in.domain.Comment.entity.Comment;
import com.inProject.in.domain.MToNRelation.ApplicantPostRelation.entity.ApplicantPostRelation;
import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.MToNRelation.RolePostRelation.entity.RolePostRelation;
import com.inProject.in.domain.MToNRelation.TagPostRelation.entity.TagPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import lombok.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PostDto {
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

    public Post toEntity(){
        return Post.builder()
                .username(username)
                .type(type)
                .title(title)
                .text(text)
                .comment_cnt(comment_cnt)
                .applicantPostRelationList(applicantPostRelationList)
                .commentList(commentList)
                .tagPostRelationList(tagPostRelationList)
                .clipPostRelationList(clipPostRelationList)
                .rolePostRelationList(rolePostRelationList)
                .build();
    }
}


