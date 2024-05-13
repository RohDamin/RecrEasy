package codemin.recreasy.service;

import codemin.recreasy.domain.Quiz;
import codemin.recreasy.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    @Transactional
    public void saveQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public List<Quiz> findQuizs() {
        return quizRepository.findAll();
    }

    public Quiz findOne(Long quizId) {
        return quizRepository.findOne(quizId);
    }
}
