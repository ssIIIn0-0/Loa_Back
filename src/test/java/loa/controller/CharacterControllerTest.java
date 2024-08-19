package loa.controller;

import loa.service.CharacterApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterApiService characterApiService;

    @Test
    public void testGetCharacterProfiles() throws Exception {
        String characterName = "ssIIIn";
        String mainServer = "루페온";

        // 필요한 경우, characterApiService에 대한 모의 응답 설정
        // when(characterApiService.getCharacterSiblings(...)).thenReturn(...);

        mockMvc.perform(get("/lostark/character")
                        .param("characterName", characterName)
                        .param("mainServer", mainServer))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
