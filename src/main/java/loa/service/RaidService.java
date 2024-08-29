package loa.service;

import loa.dto.CharacterDto;
import loa.entity.Raid;
import loa.entity.Character;
import loa.repository.RaidRepository;
import loa.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Character addCharacterToRaid(Long raidId, CharacterDto characterDto) {
        Raid raid = raidRepository.findById(raidId).orElseThrow(() -> new IllegalArgumentException("Invalid Raid ID"));
        Character character = new Character();
        character.setName(characterDto.getName());
        character.setCharacterClass(characterDto.getCharacterClass());
        character.setLevel(characterDto.getLevel());
        character.setServerName(characterDto.getServerName());
        character.setRaid(raid);
        return characterRepository.save(character);
    }

    public List<Raid> getAllRaids() {
        return raidRepository.findAll();
    }

    // 공대 상세 정보 조회
    public Raid getRaidById(Long raidId) {
        return raidRepository.findById(raidId).orElseThrow(() -> new IllegalArgumentException("Invalid Raid ID"));
    }

    // 공대 수정
    public Raid updateRaid(Long raidId, Raid updatedRaid) {
        Raid raid = raidRepository.findById(raidId).orElseThrow(() -> new IllegalArgumentException("Invalid Raid ID"));
        raid.setName(updatedRaid.getName());
        raid.setCharacters(updatedRaid.getCharacters());
        return raidRepository.save(raid);
    }

    // 공대 삭제
    public void deleteRaid(Long raidId) {
        raidRepository.deleteById(raidId);
    }

    // 공대 캐릭터 삭제
    @Transactional
    public void removeCharacterFromRaid(Long raidId, Long characterId) {
        Raid raid = raidRepository.findById(raidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Raid ID"));
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Character ID"));

        if (!character.getRaid().getId().equals(raidId)) {
            throw new IllegalArgumentException("Character does not belong to the specified Raid");
        }

        characterRepository.delete(character);
    }
}
