package codemin.recreasy.repository;

import codemin.recreasy.domain.GameSlot;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameSlotRepository {
    private final EntityManager em;

    public void save(GameSlot gameSlot) {
        if (gameSlot.getGameSlotId() == null) {
            em.persist(gameSlot);
        } else {
            em.merge(gameSlot);
        }
    }

    public GameSlot findOne(Long id) {
        return em.find(GameSlot.class, id);
    }

    public List<GameSlot> findAll() {
        return em.createQuery("select gs from GameSlot gs", GameSlot.class).getResultList();
    }
}
