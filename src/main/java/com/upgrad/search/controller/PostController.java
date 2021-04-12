package com.upgrad.search.controller;

import com.upgrad.search.model.Post;
import com.upgrad.search.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    /*
    /posts   -GET
    /posts/id  -GET
    /posts/   -POST
    /posts/id  -DELETE
    /posts/id   - put
    */

    @RequestMapping("/posts")              //response of this GET request will be JSON
    public List<Post> getAllPosts() {
        return this.postService.getAllPosts();

    }

    //Path variable is used to pass specific data to the URI
    @RequestMapping("/posts/{id}")
    public Post getPost(@PathVariable Integer id) {
        return this.postService.getPost(id);

    }

    //RequestBody helps you map the body you posted on the front end in the variable you give as arguement.
    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    public String addPost(@RequestBody Post post) {
        post.setDate(new Date());
        postService.addPost(post);
        String response = "{\"success\":true,\"message\":\"Post has been added successfully\"}";
        return response;
    }
    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Integer id) {
        this.postService.deletePost(id);
        String response = "{\"success\":true,\"message\":\"Post has been deleted successfully\"}";
        return response;
    }

}
