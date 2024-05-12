package codemin.recreasy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_description")
    private String gameDescription;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // 연관관계의 거울
    private Post post;

    @OneToMany(mappedBy = "game") // 연관관계의 거울
    private List<GameQuiz> gameQuizs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 연관관계의 주인
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_slot_id") // 연관관계의 주인
    private GameSlot gameSlot;

    /**
     * 연관관계 편의 메서드
     */
    public void setUser(User user) {
        this.user = user;
        user.getGames().add(this);
    }

    public void setGameSlot(GameSlot gameSlot) {
        this.gameSlot = gameSlot;
        gameSlot.getGames().add(this);
    }
}
