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

    @Column(name = "max_slot")
    private int maxSlot;

    @Column(name = "remaining_slot")
    private int remainingSlot;

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
}
