package ua.charity.GetHelpUaBot.cache;

import org.springframework.stereotype.Service;
import ua.charity.GetHelpUaBot.handlers.BotState;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Nechytailo
 */

@Service
public class UserDataCache implements DataCache {
    private Map<Long, BotState> usersBotStates = new HashMap<>();

    private static Long currentUserId;

    @Override
    public void setUserCurrentBotState(Long userId, BotState botState) {
        usersBotStates.put(userId, botState);
    }

    @Override
    public BotState getUserCurrentBotState(Long userId) {
        BotState botState = usersBotStates.get(userId);
        if (botState == null) {
            botState = BotState.SIGN_UP;
        }

        return botState;
    }

    public Long getCurrentUserId() {
        return currentUserId;
    }
    public void setCurrentUserId(Long userid) {
        currentUserId = userid;
    }
}
