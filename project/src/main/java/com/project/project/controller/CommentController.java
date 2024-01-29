package com.project.project.controller;

import com.project.project.model.Comment;
import com.project.project.service.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person-data/records")
public class CommentController {

    @Autowired CommentService commentService;

    @PostMapping("/{record_id}/comments/create")
    private void create(@PathVariable Integer record_id, @RequestBody Comment comment) {
        commentService.addUpdate(comment);
    }


}
