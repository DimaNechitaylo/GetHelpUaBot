package ua.charity.GetHelpUaBot.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SessionManager {

    private HashMap<Long, Session> sessions = new HashMap<>();

    private Session currentSession;

    public void load(Long userid) {
        if(!this.sessions.containsKey(userid)) {
            this.sessions.put(userid, new Session());
        }
        this.currentSession = this.sessions.get(userid);
    }

    public <T> T getProperty(String key, Class<T> targetClass) {
        return this.currentSession.getProperty(key, targetClass);
    }

    public <T> void setProperty(String key, T value) {
        this.currentSession.setProperty(key, value);
    }

}
