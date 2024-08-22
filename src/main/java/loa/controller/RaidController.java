package loa.controller;

import loa.entity.Raid;
import loa.entity.Character;
import loa.service.RaidService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/raids")
@RequiredArgsConstructor
public class RaidController {
    private final RaidService raidService;

    @PostMapping
    public ResponseEntity<Raid> createRaid(@RequestParam String name) {
        return ResponseEntity.ok(raidService.createRaid(name));
    }

    @PostMapping("/{raidId}/characters")
    public ResponseEntity<Character> addCharacterToRaid(
            @PathVariable Long raidId,
            @RequestParam String name,
            @RequestParam String characterClass,
            @RequestParam int level,
            @RequestParam String serverName
    ) {
        return ResponseEntity.ok(raidService.addCharacterToRaid(raidId, name, characterClass, level, serverName));
    }

    @GetMapping
    public ResponseEntity<List<Raid>> getAllRaids() {
        return ResponseEntity.ok(raidService.getAllRaids());
    }
}