package ua.charity.GetHelpUaBot.handlers.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.DataCache;
import ua.charity.GetHelpUaBot.handlers.BotState;
import ua.charity.GetHelpUaBot.handlers.InputMessageHandler;
import ua.charity.GetHelpUaBot.handlers.states.States;
import ua.charity.GetHelpUaBot.service.UserService;
import ua.charity.GetHelpUaBot.utils.LocaleTextManager;

@Component
public class TestSecHendler implements InputMessageHandler {

    @Autowired
    private DataCache userDataCache;

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private UserService UserServiceImpl;

    @Autowired
    private LocaleTextManager messageService;


    @Override
    public void handle(Message message) {
        States.getStartMenuState(messageSender, userDataCache, message.getFrom().getId());
        userDataCache.setUserCurrentBotState(message.getFrom().getId(), BotState.SIGN_UP);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.TEST2;
    }
}
