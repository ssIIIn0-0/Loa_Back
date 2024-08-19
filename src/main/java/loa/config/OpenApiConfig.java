package loa.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private final Dotenv dotenv = Dotenv.load();

    public String getOpenApiKey() {
        return dotenv.get("OPEN_API_KEY");
    }

    public String getApiUrl() {
        return dotenv.get("OPEN_API_URL", "https://developer-lostark.game.onstove.com");
    }
}
