package ua.charity.GetHelpUaBot.handlers.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.StateCache;
import ua.charity.GetHelpUaBot.handlers.BotState;
import ua.charity.GetHelpUaBot.handlers.InputMessageHandler;
import ua.charity.GetHelpUaBot.handlers.states.DeterminedStates;
import ua.charity.GetHelpUaBot.service.UserService;
import ua.charity.GetHelpUaBot.utils.LocaleTextManager;

@Component
    public class TestHendler implements InputMessageHandler {

        @Autowired
        private StateCache userStateCache;

        @Autowired
        private MessageSender messageSender;

        @Autowired
        private UserService UserServiceImpl;

        @Autowired
        private LocaleTextManager messageService;


        @Override
        public void process(Message message) {
            DeterminedStates.getStartMenuState(messageSender, userStateCache, message.getFrom().getId());
        }

        @Override
        public BotState getStateName() {
            return BotState.TEST1;
        }
    }

