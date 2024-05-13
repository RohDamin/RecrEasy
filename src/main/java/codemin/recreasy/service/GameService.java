package codemin.recreasy.service;

import codemin.recreasy.domain.Game;
import codemin.recreasy.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    @Transactional
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public List<Game> findGames() {
        return gameRepository.findAll();
    }

    public Game findOne(Long gameId) {
        return gameRepository.findOne(gameId);
    }
}
