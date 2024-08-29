package loa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {
    private String name;
    private String characterClass;
    private int level;
    private String serverName;
}
