package codemin.recreasy.service;

import codemin.recreasy.domain.Game;
import codemin.recreasy.domain.Quiz;
import codemin.recreasy.repository.GameQuizRepository;
import codemin.recreasy.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class GameQuizServiceTest {

    /**
     * 테스트 요구사항
     * - 게임퀴즈 생성이 성공해야 한다
     */

    @PersistenceContext EntityManager em;
    @Autowired GameQuizRepository gameQuizRepository;
    @Autowired GameQuizService gameQuizService;

    @Test
    void 게임퀴즈생성() throws Exception {
        // given
        Game game = createGame();
        List<Long> quizList = createQuizs();

        // when
        Long gameId = gameQuizService.gameQuiz(game.getGameId(), quizList);

        // then
        em.flush();
        assertEquals(gameId, game.getGameId());
    }

    private Game createGame() {
        Game game = new Game();
        game.setGameName("Game1");
        em.persist(game);
        return game;
    }

    private List<Long> createQuizs() {
        Quiz quiz1 = new Quiz();
        quiz1.setQuestion("Question1");
        quiz1.setAnswer("Answer1");

        Quiz quiz2 = new Quiz();
        quiz2.setQuestion("Question2");
        quiz2.setAnswer("Answer2");

        em.persist(quiz1);
        em.persist(quiz2);

        List<Long> quizList = new ArrayList<Long>();
        quizList.add(quiz1.getQuizID());
        quizList.add(quiz2.getQuizID());

        return quizList;
    }


}
