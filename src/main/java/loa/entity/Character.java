package loa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "raid_character")
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
    @JsonBackReference
    private Raid raid;

}