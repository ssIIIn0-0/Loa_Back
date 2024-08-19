package loa.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Data
public class CharacterProfileDto {

    @JsonProperty("CharacterImage")
    private String characterImage;

    @JsonProperty("ExpeditionLevel")
    private int expeditionLevel;

    @JsonProperty("PvpGradeName")
    private String pvpGradeName;

    @JsonProperty("TownLevel")
    private Integer townLevel;

    @JsonProperty("TownName")
    private String townName;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("GuildMemberGrade")
    private String guildMemberGrade;

    @JsonProperty("GuildName")
    private String guildName;

    @JsonProperty("UsingSkillPoint")
    private int usingSkillPoint;

    @JsonProperty("TotalSkillPoint")
    private int totalSkillPoint;

    @JsonProperty("Stats")
    private List<Stat> stats;

    @JsonProperty("Tendencies")
    private List<Tendency> tendencies;

    @JsonProperty("ArkPassive")
    private ArkPassive arkPassive;

    @JsonProperty("ServerName")
    private String serverName;

    @JsonProperty("CharacterName")
    private String characterName;

    @JsonProperty("CharacterLevel")
    private int characterLevel;

    @JsonProperty("CharacterClassName")
    private String characterClassName;

    @JsonProperty("ItemAvgLevel")
    private String itemAvgLevel;

    @JsonProperty("ItemMaxLevel")
    private String itemMaxLevel;

    @Data
    public static class Stat {
        @JsonProperty("Type")
        private String type;

        @JsonProperty("Value")
        private String value;

        @JsonProperty("Tooltip")
        private List<String> tooltip;
    }

    @Data
    public static class Tendency {
        @JsonProperty("Type")
        private String type;

        @JsonProperty("Point")
        private int point;

        @JsonProperty("MaxPoint")
        private int maxPoint;
    }

    @Data
    public static class ArkPassive {
        @JsonProperty("IsArkPassive")
        private boolean isArkPassive;

        @JsonProperty("Points")
        private List<ArkPassivePoint> points;

        @Data
        public static class ArkPassivePoint {
            @JsonProperty("Name")
            private String name;

            @JsonProperty("Value")
            private int value;

            @JsonProperty("Tooltip")
            private String tooltip;
        }
    }
}
