package codemin.recreasy.repository;

import codemin.recreasy.domain.Quiz;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizRepository {
    private final EntityManager em;

    public void save(Quiz quiz) {
        if (quiz.getQuizID() == null) {
            em.persist(quiz);
        } else {
            em.merge(quiz);
        }
    }

    public Quiz findOne(Long id) {
        return em.find(Quiz.class, id);
    }

    public List<Quiz> findAll() {
        return em.createQuery("select q from Quiz q", Quiz.class).getResultList();
    }
}
