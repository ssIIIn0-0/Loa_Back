package loa.service;

import loa.config.OpenApiConfig;
import loa.dto.CharacterProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final RestTemplate restTemplate;
    private final OpenApiConfig openApiConfig;

    public CharacterProfileDto getCharacterProfile(String characterName) {
        try {
            // characterName을 UTF-8로 인코딩
            // String encodedCharacterName = URLEncoder.encode(characterName, StandardCharsets.UTF_8.toString());

            // 인코딩된 URL을 직접 사용
            String url = openApiConfig.getApiUrl() + "/armories/characters/" + characterName + "/profiles";

            HttpHeaders headers = new HttpHeaders();
            headers.set("accept", "application/json");
            headers.set("authorization", "Bearer " + openApiConfig.getOpenApiKey());

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<CharacterProfileDto> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    CharacterProfileDto.class
            );

            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch character profile", e);
        }
    }
}
