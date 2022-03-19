package ua.charity.GetHelpUaBot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.charity.GetHelpUaBot.botapi.Bot;

/**
 * @author Dmitry Nechytailo
 */

@Slf4j
@RestController
public class WebHookController {
    private final Bot bot;

    public WebHookController(Bot bot) {
        this.bot = bot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }

}