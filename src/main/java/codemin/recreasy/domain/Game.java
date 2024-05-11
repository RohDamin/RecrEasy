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
    private List<GameQuiz> gameQuiz = new ArrayList<>();
}
