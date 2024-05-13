package codemin.recreasy.domain;

import codemin.recreasy.exception.NotEnoughGameSlotException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String email;

    private String password;

    private int point;

    private int gameSlotCount = 2;

    private int gameSlotLimit = 10;

    @OneToMany(mappedBy = "user") // 연관관계의 거울
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user") // 연관관계의 거울
    private List<GameSlot> gameSlots = new ArrayList<>();

    @OneToMany(mappedBy = "user") // 연관관계의 거울
    private List<Game> games = new ArrayList<>();

    /**
     * 비즈니스 로직
     */
    public void addGameSlotCount() {
        int restGameSlot = this.gameSlotLimit - this.gameSlotCount;
        if (restGameSlot == 0) {
            throw new NotEnoughGameSlotException("All game slots are full");
        }
        this.gameSlotCount++;
    }
}
