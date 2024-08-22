package loa.service;

import loa.entity.Raid;
import loa.entity.Character;
import loa.repository.RaidRepository;
import loa.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaidService {
    private final RaidRepository raidRepository;
    private final CharacterRepository characterRepository;

    public Raid createRaid(String raidName) {
        Raid raid = new Raid();
        raid.setName(raidName);
        return raidRepository.save(raid);
    }

    public Character addCharacterToRaid(Long raidId, String characterName, String characterClass, int level, String serverName) {
        Raid raid = raidRepository.findById(raidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid raid ID"));

        Character character = new Character();
        character.setName(characterName);
        character.setCharacterClass(characterClass);
        character.setLevel(level);
        character.setServerName(serverName);
        character.setRaid(raid);

        return characterRepository.save(character);
    }

    public List<Raid> getAllRaids() {
        return raidRepository.findAll();
    }
}
