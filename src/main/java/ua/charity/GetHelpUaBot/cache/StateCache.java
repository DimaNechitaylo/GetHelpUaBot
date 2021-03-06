package ua.charity.GetHelpUaBot.cache;

import ua.charity.GetHelpUaBot.handlers.BotState;

public interface StateCache {

    void setUserCurrentBotState(Long userId, BotState botState);

    BotState getUserCurrentBotState(Long userId);

    Long getCurrentUserId();

    void setCurrentUserId(Long userid);

}
