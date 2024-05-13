package codemin.recreasy.service;

import codemin.recreasy.domain.Game;
import codemin.recreasy.domain.GameQuiz;
import codemin.recreasy.domain.Quiz;
import codemin.recreasy.repository.GameQuizRepository;
import codemin.recreasy.repository.GameRepository;
import codemin.recreasy.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor

public class GameQuizService {
    private final GameRepository gameRepository;
    private final QuizRepository quizRepository;
    private final GameQuizRepository gameQuizRepository;

    /**
     * 게임 퀴즈 생성
     */
    @Transactional
    public Long gameQuiz(Long gameId, List<Long> quizIds) {
        // 게임 엔티티 조회
        Game game = gameRepository.findOne(gameId);

        for (Long quizId : quizIds) {
            // 퀴즈 엔티티 조회
            Quiz quiz = quizRepository.findOne(quizId);

            // 게임퀴즈 생성
            GameQuiz gameQuiz = new GameQuiz();

            // 게임퀴즈에 게임, 퀴즈 저장
            gameQuiz.setGame(game);
            gameQuiz.setQuiz(quiz);

            // 특정 게임에 게임퀴즈 인스턴스 추가
            game.getGameQuizs().add(gameQuiz);
        }

        // 게임 저장
        gameRepository.save(game);

        // 게임 Id 리턴
        return game.getGameId();
    }
}
