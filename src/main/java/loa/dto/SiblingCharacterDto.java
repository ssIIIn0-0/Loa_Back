package loa.dto;

import lombok.Data;

@Data
public class SiblingCharacterDto {
    private String serverName;
    private String characterName;
    private int characterLevel;
    private String characterClassName;
    private String itemAvgLevel;
    private String itemMaxLevel;
}
