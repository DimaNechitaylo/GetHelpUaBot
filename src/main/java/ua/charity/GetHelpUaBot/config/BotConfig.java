package ua.charity.GetHelpUaBot.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BotConfig {
    String webHookPath;
    String username;
    String token;
}