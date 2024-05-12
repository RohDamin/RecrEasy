package codemin.recreasy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue
    @Column(name = "quiz_id")
    private Long quizID;

    private String question;
    private String answer;
    private String category;

    @OneToMany(mappedBy = "quiz") // 연관관계의 거울
    private List<GameQuiz> gameQuizs = new ArrayList<>();
}
