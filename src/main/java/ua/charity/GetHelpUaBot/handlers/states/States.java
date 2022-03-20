package ua.charity.GetHelpUaBot.handlers.states;

import org.springframework.stereotype.Component;
import ua.charity.GetHelpUaBot.boilerplate.Button;
import ua.charity.GetHelpUaBot.boilerplate.MessageSender;
import ua.charity.GetHelpUaBot.cache.DataCache;
import ua.charity.GetHelpUaBot.handlers.BotState;

import java.util.Arrays;

@Component
public class States {
    public static void getStartMenuState(MessageSender messageSender, DataCache userDataCache, Long userId){
        messageSender.setChatId(userDataCache.getCurrentUserId());
        messageSender.setText("StartMenu");
        messageSender.setButtons(Arrays.asList(new Button("TEST1"),
                new Button("TEST2")));
        messageSender.sendMessage();
        userDataCache.setUserCurrentBotState(userId, BotState.SIGN_UP);
    }

    public static void getTestFstState(MessageSender messageSender, DataCache userDataCache, Long userId){
        messageSender.setChatId(userDataCache.getCurrentUserId());
        messageSender.setText("test1");
        messageSender.setButtons(Arrays.asList(new Button("/start"), new Button("stng1")));
        messageSender.sendMessage();
        userDataCache.setUserCurrentBotState(userId, BotState.TEST1);
    }

    public static void getTestScndMenuState(MessageSender messageSender, DataCache userDataCache, Long userId){
        messageSender.setChatId(userDataCache.getCurrentUserId());
        messageSender.setText("test2");
        messageSender.setButtons(Arrays.asList(new Button("/start"), new Button("stng2")));
        messageSender.sendMessage();
        userDataCache.setUserCurrentBotState(userId, BotState.TEST2);
    }
}
