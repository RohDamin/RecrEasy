package codemin.recreasy.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GameSlot {
    @Id
    @GeneratedValue
    @Column(name = "game_slot_id")
    private Long gameSlotId;

    @Enumerated(EnumType.STRING)
    private GameSlotStatus state; // 슬롯상태 [EMPTY, GAME]

    @ManyToOne(fetch = FetchType.LAZY) // 연관관계의 주인
    @JoinColumn(name = "user_id") // 연관관계의 주인
    private User user;

    @OneToMany(mappedBy = "gameSlot") // 연관관계의 거울
    private List<Game> games = new ArrayList<>();

    /**
     * 연관관계 편의 메서드
     */
    public void setUser(User user) {
        this.user = user;
        user.getGameSlots().add(this);
    }

    /**
     * 생성 메서드
     */
    public static GameSlot createGameSlot(User user) {
        GameSlot gameSlot = new GameSlot();
        gameSlot.setUser(user);
        gameSlot.setState(GameSlotStatus.empty); // 빈 슬롯 생성
        return gameSlot;
    }
}
