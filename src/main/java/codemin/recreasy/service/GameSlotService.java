package codemin.recreasy.service;

import codemin.recreasy.domain.Game;
import codemin.recreasy.domain.GameSlot;
import codemin.recreasy.repository.GameSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameSlotService {
    private final GameSlotRepository gameSlotRepository;

    @Transactional
    public void saveGameSlot(GameSlot gameSlot) {
        gameSlotRepository.save(gameSlot);
    }

    public List<GameSlot> findGameSlots() {
        return gameSlotRepository.findAll();
    }

    public GameSlot findOne(Long gameSlotId) {
        return gameSlotRepository.findOne(gameSlotId);
    }
}
