package loa.controller;

import loa.dto.CharacterProfileDto;
import loa.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping("/api/characters/profiles")
    public CharacterProfileDto getCharacterProfile(@RequestParam String characterName) {
        System.out.println("controller Character Name: " + characterName);

        return characterService.getCharacterProfile(characterName);
    }
}
