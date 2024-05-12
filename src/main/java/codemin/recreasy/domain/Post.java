package codemin.recreasy.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long postId;

    @JoinColumn(name = "title")
    private String title;

    @JoinColumn(name = "created_at")
    private LocalDateTime createdAt;

    @JoinColumn(name = "updated_at")
    private LocalDateTime updatedAt;

    @JoinColumn(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JoinColumn(name = "view_count")
    private int viewCount;

    @JoinColumn(name = "download_count")
    private int downloadCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 연관관계의 주인
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id") // 연관관계의 주인
    private Game game;

    /**
     * 연관관계 편의 메서드
     */
    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }

    public void setGame(Game game) {
        this.game = game;
        user.getPosts().add(this);
    }
}
