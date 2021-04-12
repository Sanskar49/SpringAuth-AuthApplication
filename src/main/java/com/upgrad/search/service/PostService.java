package com.upgrad.search.service;

import com.upgrad.search.model.Post;
import com.upgrad.search.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return (List<Post>) this.postRepository.findAll();
    }
    public void addPost(Post post) {
        this.postRepository.save(post);
    }

//    //This is also an option
//    public Optional<Post> getPost(Integer id) {
//        return this.postRepository.findById(id);
//    }
    //Sometimes findById could probably return you a null, so findById asks you to return Optional in that case.
    public Post getPost(Integer id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()) {
            return post.get();
        } else {
            return null;
        }
    }
    public void deletePost(Integer id) {
        this.postRepository.deleteById(id);
    }
    public boolean updatePost(Integer id, Post post) {
        //check the specific post by its id
        //If it exists, then update it, otherwise do nothing


        //if the post exists then it will update, i.e. save it again, or else i.e. if the post does not exist
        //will do nothing.

        //checking whether that id exists on the database or not.
        if(this.postRepository.existsById(id)) {
            this.postRepository.save(post);
            return true;
        }
        else {
            return false;
        }


    }



}
