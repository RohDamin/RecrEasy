package codemin.recreasy.repository;

import codemin.recreasy.domain.GameQuiz;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameQuizRepository {
    private final EntityManager em;

    public void save(GameQuiz gameQuiz) {
        em.persist(gameQuiz);
    }

    public GameQuiz findOne(Long id) {
        return em.find(GameQuiz.class, id);
    }

//    public List<Game> findAll() {
//        return em.createQuery("select g from Game g", Game.class).getResultList();
//    }
}
