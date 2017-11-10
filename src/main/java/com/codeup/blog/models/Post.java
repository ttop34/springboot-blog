package com.codeup.blog.models;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false, length=100)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {

        return user;
    }

    public Post(){
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body, User user){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId(){
        return id;
    }
}