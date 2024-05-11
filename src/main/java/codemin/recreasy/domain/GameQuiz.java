package codemin.recreasy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GameQuiz {
    @Id
    @GeneratedValue
    @Column(name = "game_quiz_id")
    private Long gameQuizId;

    @ManyToOne(fetch = FetchType.LAZY) // 연관관계의 주인
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY) // 연관관계의 주인
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
