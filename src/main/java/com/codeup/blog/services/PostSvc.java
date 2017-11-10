package com.codeup.blog.services;
import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Step 1 Annotate class- Spring Boot can't create object
public class PostSvc {

    private final PostsRepository postsDoa;

    @Autowired
    public PostSvc(PostsRepository postsDoa) {
        this.postsDoa = postsDoa;
    }

    public Iterable<Post> findAll() {  //returns ALL posts and takes place of SHOWALL in posts controller
        return postsDoa.findAll();
    }

    public Post save(Post post) {
        postsDoa.save(post);
        return post;
    }

    public Post findOne(long id) {
        return postsDoa.findOne(id);
    }

    public void deletePost(long id){
        postsDoa.delete(id);
    }


}