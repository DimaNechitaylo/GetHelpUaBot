package ua.charity.GetHelpUaBot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ua.charity.GetHelpUaBot.botapi.Bot;
import ua.charity.GetHelpUaBot.botapi.TelegramFacade;
/**
 * @author Dmitry Nechytailo
 */

@Configuration
public class AppConfig {
    private BotConfig botConfig;

    public AppConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public Bot getHelpUaBot(TelegramFacade telegramFacade){
        Bot bot = new Bot(telegramFacade);
        bot.setWebHookPath(botConfig.getWebHookPath());
        bot.setBotUsername(botConfig.getUsername());
        bot.setBotToken(botConfig.getToken());
        return bot;
    }
}
