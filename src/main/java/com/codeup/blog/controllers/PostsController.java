package com.codeup.blog.controllers;
import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@Controller //Step 1 Annotate
public class PostsController {
    private final PostSvc postSvc; //create property
    @Autowired //Constructor injection, passed to controller; Spring knows to use this one and ignore others
    public PostsController(PostSvc postSvc){ //constructor same name as the class; pass property
        this.postSvc = postSvc;
    }
    @GetMapping("/posts") //Step 2 what url want to respond to
    public String showAll(Model vModel) {
//        ArrayList<Post> posts = new ArrayList<>();
//
//        posts.add(new Post("Title One", "Body goes here"));
//        posts.add(new Post("Title 2", "Body goes here"));
//        posts.add(new Post("Title 3", "Body goes here"));
//        List<Post> posts = postSvc.findAll();
//        vModel.addAttribute("posts", posts);
        vModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id, Model vModel) {
//        Post post = new Post("Example 1", "Body goes here");
        vModel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }
    @GetMapping("/posts/create") //url to view
    public String ViewCreateForm(Model vModel) { //make sure has model that represents view
        vModel.addAttribute("post", new Post());
        return "posts/create"; //actual file returned
    }
    @PostMapping("/posts/create") //
    public String CreatePost(@ModelAttribute Post post) { //use model attribute; accepts object of type post
        postSvc.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }
}
