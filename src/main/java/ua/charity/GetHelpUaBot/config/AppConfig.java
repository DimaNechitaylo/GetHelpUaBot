package ua.charity.GetHelpUaBot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;
import ua.charity.GetHelpUaBot.botapi.Bot;
import ua.charity.GetHelpUaBot.botapi.UserMessageContext;
 

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
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Bot getHelpUaBot(UserMessageContext userMessageContext){
        Bot bot = new Bot(userMessageContext);
        bot.setWebHookPath(botConfig.getWebHookPath());
        bot.setBotUsername(botConfig.getUsername());
        bot.setBotToken(botConfig.getToken());
        return bot;
    }
}
