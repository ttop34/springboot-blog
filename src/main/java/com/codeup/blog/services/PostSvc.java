package com.codeup.blog.services;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service //Step 1 Annotate class- Spring Boot can't create object
public class PostSvc {
    private List<Post> posts = new ArrayList<>(); //keep an array list of posts internally
    public PostSvc() { //constructor
        createPosts();
    }
    public List<Post> findAll() {  //returns ALL posts and takes place of SHOWALL in posts controller
        return posts;
    }
    public Post save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }
    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }
    private void createPosts() { // same data that was in SHOWALL in posts controller
        // create some post objects and add them to the posts list
        // with the save method
        this.save(new Post(
                1L, "First Title", "Description 1"
        ));
        this.save(new Post(
                2L, "Second Title", "Description 2"
        ));
        this.save(new Post(
                3L, "Third Title", "Description 3"
        ));
        this.save(new Post(
                4L, "Fourth Title", "Description 4"
        ));
    }
}