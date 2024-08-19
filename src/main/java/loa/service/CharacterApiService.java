package loa.service;

import loa.config.OpenApiConfig;
import loa.dto.CharacterProfileDto;
import loa.dto.SiblingCharacterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterApiService {

    private final RestTemplate restTemplate;
    private final OpenApiConfig openApiConfig;

    // 캐릭터 목록 가져오기
    public List<SiblingCharacterDto> getCharacterSiblings(String characterName) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(openApiConfig.getApiUrl())
                    .pathSegment("characters", characterName, "siblings")
                    .toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.set("accept", "application/json");
            headers.set("authorization", "Bearer " + openApiConfig.getOpenApiKey());

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<SiblingCharacterDto[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    SiblingCharacterDto[].class
            );

            // 응답 로그 출력
            Arrays.stream(response.getBody()).forEach(sibling -> System.out.println("Server Name: " + sibling.getServerName()));

            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch character siblings", e);
        }
    }

    // 캐릭터 프로필 가져오기
    public CharacterProfileDto getCharacterProfile(String characterName) {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch character profile", e);
        }
    }
}
