package codemin.recreasy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String password;

    private int point;

    @OneToMany(mappedBy = "user") // 연관관계의 거울
    private List<Post> posts;

    @OneToMany(mappedBy = "user") // 연관관계의 거울
    private List<GameSlot> gameSlots;
}
