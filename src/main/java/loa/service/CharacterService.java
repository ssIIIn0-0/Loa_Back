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
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final RestTemplate restTemplate;
    private final OpenApiConfig openApiConfig;

    public CharacterProfileDto getCharacterProfile(String characterName) {
        String url = UriComponentsBuilder.fromHttpUrl(openApiConfig.getApiUrl())
                .pathSegment("armories", "characters", characterName, "profiles")
                .toUriString();

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
    }
}
