package com.example.demo.domain.commentdomain;

import java.util.Date;
import java.util.UUID;

import com.example.demo.dto.commentdtos.CommentDTO;
import com.example.demo.dto.commentdtos.CreateCommentDTO;

public class CommentService {
    public static Comment create(CreateCommentDTO dto) {
        Comment comment = new Comment();
        comment.id = UUID.randomUUID();
        comment.text = dto.text;
        comment.date = new Date();
        comment.score = dto.score;
        return comment;
    }
    public static CommentDTO createDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.id = comment.id;
        commentDTO.text = comment.text;
        commentDTO.date = comment.date;
        commentDTO.score = comment.score;
        return commentDTO;
    }
}
