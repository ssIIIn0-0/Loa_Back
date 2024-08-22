package loa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String characterClass;
    private int level;
    private String serverName;

    @ManyToOne
    @JoinColumn(name = "raid_id")
    private Raid raid;
}