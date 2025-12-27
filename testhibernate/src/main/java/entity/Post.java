package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(nullable = false)
    private String tittle;

    @ManyToOne
    @JoinColumn(name  = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(){
        super();
    }

    public Post(String tittle, int postId) {
        this.tittle = tittle;
        this.postId = postId;
    }

    public Post(String tittle) {
        this.tittle = tittle;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
