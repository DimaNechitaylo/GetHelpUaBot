package ua.charity.GetHelpUaBot.handlers.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.boilerplate.Button;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.DataCache;
import ua.charity.GetHelpUaBot.handlers.BotState;
import ua.charity.GetHelpUaBot.handlers.InputMessageHandler;
import ua.charity.GetHelpUaBot.handlers.states.States;
import ua.charity.GetHelpUaBot.service.UserService;
import ua.charity.GetHelpUaBot.utils.LocaleTextManager;

import java.util.Arrays;

@Component
public class StartMenuHendler implements InputMessageHandler {

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
        switch (message.getText()) {
            case "TEST1":
                States.getTestFstState(messageSender, userDataCache, message.getFrom().getId());
                break;
            case "TEST2":
                States.getTestScndMenuState(messageSender, userDataCache, message.getFrom().getId());
                break;
            case "/start":
                States.getStartMenuState(messageSender, userDataCache, message.getFrom().getId());
                break;
            default:
                break;
        }
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SIGN_UP;
    }
}
