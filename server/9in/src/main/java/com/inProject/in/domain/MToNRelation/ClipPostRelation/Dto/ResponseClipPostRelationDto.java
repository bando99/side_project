package com.inProject.in.domain.MToNRelation.ClipPostRelation.Dto;

import com.inProject.in.domain.MToNRelation.ClipPostRelation.entity.ClipPostRelation;
import com.inProject.in.domain.Post.entity.Post;
import com.inProject.in.domain.User.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseClipPostRelationDto {
    private Long id;
    private User clipUser;
    private Post clipPost;

    public ResponseClipPostRelationDto(ClipPostRelation clipPostRelation){
        this.id = clipPostRelation.getId();
        this.clipUser = clipPostRelation.getClipUser();
        this.clipPost = clipPostRelation.getClipedPost();
    }
}
