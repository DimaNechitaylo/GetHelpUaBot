package ua.charity.GetHelpUaBot.handlers.states;

import org.springframework.stereotype.Component;
import ua.charity.GetHelpUaBot.boilerplate.Button;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.StateCache;
import ua.charity.GetHelpUaBot.handlers.BotState;

import java.util.Arrays;

@Component
public class DeterminedStates {
    public static void getStartMenuState(MessageSender messageSender, StateCache userStateCache, Long userId){
        messageSender.setChatId(userStateCache.getCurrentUserId());
        messageSender.setText("StartMenu");
        messageSender.setButtons(Arrays.asList(new Button("Test1"),
                new Button("Test2")));
        messageSender.sendMessage();
        userStateCache.setUserCurrentBotState(userId, BotState.SIGN_UP);
    }

    public static void getTestFstState(MessageSender messageSender, StateCache userStateCache, Long userId){
        messageSender.setChatId(userStateCache.getCurrentUserId());
        messageSender.setText("test1");
        messageSender.setButtons(Arrays.asList(new Button("/start"), new Button("stng1")));
        messageSender.sendMessage();
        userStateCache.setUserCurrentBotState(userId, BotState.TEST1);
    }

    public static void getTestScndMenuState(MessageSender messageSender, StateCache userStateCache, Long userId){
        messageSender.setChatId(userStateCache.getCurrentUserId());
        messageSender.setText("test2");
        messageSender.setButtons(Arrays.asList(new Button("/start"), new Button("stng2")));
        messageSender.sendMessage();
        userStateCache.setUserCurrentBotState(userId, BotState.TEST2);
    }

    public static void getProcessContactState(MessageSender messageSender, StateCache userStateCache, Long id) {
        messageSender.setChatId(userStateCache.getCurrentUserId());
        messageSender.setText("test2");
        messageSender.setButtons(Arrays.asList(new Button("/start"), new Button("stng2")));
        messageSender.sendMessage();
        userStateCache.setUserCurrentBotState(id, BotState.TEST2);
    }
}
