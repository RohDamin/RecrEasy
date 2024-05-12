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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id") // 연관관계의 주인
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id") // 연관관계의 주인
    private Quiz quiz;

    /**
     * 연관관계 편의 메소드
     */
    public void setGame(Game game) {
        this.game = game;
        game.getGameQuizs().add(this);
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        quiz.getGameQuizs().add(this);
    }
}
