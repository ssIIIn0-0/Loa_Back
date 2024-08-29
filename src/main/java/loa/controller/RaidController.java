package loa.controller;

import loa.dto.CharacterDto;
import loa.entity.Raid;
import loa.entity.Character;
import loa.service.RaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/raids")
@RequiredArgsConstructor
public class RaidController {

    private final RaidService raidService;

    @PostMapping
    public ResponseEntity<Raid> createRaid(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        return ResponseEntity.ok(raidService.createRaid(name));
    }

    @PostMapping("/{raidId}/characters")
    public ResponseEntity<CharacterDto> addCharacterToRaid(
            @PathVariable Long raidId,
            @RequestBody CharacterDto characterDto
    ) {
        Character savedCharacter = raidService.addCharacterToRaid(raidId, characterDto);
        CharacterDto responseDto = new CharacterDto(savedCharacter.getName(), savedCharacter.getCharacterClass(), savedCharacter.getLevel(), savedCharacter.getServerName());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<Raid>> getAllRaids() {
        return ResponseEntity.ok(raidService.getAllRaids());
    }

    // 공대 상세 정보 조회
    @GetMapping("/{raidId}")
    public ResponseEntity<Raid> getRaidById(@PathVariable Long raidId) {
        return ResponseEntity.ok(raidService.getRaidById(raidId));
    }

    // 공대 수정
    @PutMapping("/{raidId}")
    public ResponseEntity<Raid> updateRaid(@PathVariable Long raidId, @RequestBody Raid updatedRaid) {
        return ResponseEntity.ok(raidService.updateRaid(raidId, updatedRaid));
    }

    // 공대 삭제
    @DeleteMapping("/{raidId}")
    public ResponseEntity<Void> deleteRaid(@PathVariable Long raidId) {
        raidService.deleteRaid(raidId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{raidId}/characters/{characterId}")
    public ResponseEntity<Void> removeCharacterFromRaid(
            @PathVariable Long raidId,
            @PathVariable Long characterId
    ) {
        raidService.removeCharacterFromRaid(raidId, characterId);
        return ResponseEntity.noContent().build();
    }
}
