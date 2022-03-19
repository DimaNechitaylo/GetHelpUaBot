package ua.charity.GetHelpUaBot.botapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.charity.GetHelpUaBot.cache.UserDataCache;
import ua.charity.GetHelpUaBot.exceptions.ApplicationStartException;
import ua.charity.GetHelpUaBot.handlers.BotState;
import ua.charity.GetHelpUaBot.handlers.BotStateContext;
import ua.charity.GetHelpUaBot.handlers.CallbackQueryFacade;

/**
 * @author Dmitry Nechytailo
 */

@Service
@Slf4j
public class TelegramFacade {
    private UserDataCache userDataCache;
    private BotStateContext botStateContext;
    private CallbackQueryFacade callbackQueryFacade;

    public TelegramFacade(UserDataCache userDataCache, BotStateContext botStateContext,
                          CallbackQueryFacade callbackQueryFacade) {
        this.userDataCache = userDataCache;
        this.botStateContext = botStateContext;
        this.callbackQueryFacade = callbackQueryFacade;
    }

    public void handleUpdate(Update update) {
        try {
            Long userid = -1L;

            if (update.hasCallbackQuery()) {
                log.info("New callbackQuery from User: {} with data: {}", update.getCallbackQuery().getFrom().getUserName(),
                        update.getCallbackQuery().getData());
                userid = getUserIdFromCallback(update);
                userDataCache.setCurrentUserId(userid);
                callbackQueryFacade.processCallbackQuery(update.getCallbackQuery());
            }

            Message message = update.getMessage();
            if (message != null && message.hasText()) {
                log.info("New message from User:{}, chatId: {},  with text: {}",
                        message.getFrom().getUserName(), message.getChatId(), message.getText());
                userid = getUserIdFromMessage(update);
                userDataCache.setCurrentUserId(userid);
                handleInputMessage(message);
            }

            if (userid == -1) {
                throw new ApplicationStartException("User Id could not be obtained while receiving the update");
            }
            userDataCache.setCurrentUserId(userid);


        } catch (Exception e) {
            log.error(e.getStackTrace().toString());
        }
    }


    private Long getUserIdFromCallback(Update update) {
        return update.getCallbackQuery().getFrom().getId();
    }

    private Long getUserIdFromMessage(Update update) {
        return update.getMessage().getFrom().getId();
    }

    private void handleInputMessage(Message message) {
        String inputMsg = message.getText();
        Long userId = message.getFrom().getId();
        BotState botState;

        switch (inputMsg) {
            case "/start":
                botState = BotState.SIGN_UP;
                break;
            default:
                botState = userDataCache.getUserCurrentBotState(userId);
                break;
        }

        userDataCache.setUserCurrentBotState(userId, botState);

        botStateContext.processInputMessage(botState, message);
    }
}


