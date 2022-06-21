package ua.charity.GetHelpUaBot.boilerplate;

import java.util.Optional;

public class InlineButton {

    private String text;
    private String command;
    private Optional<String> url;

    /**
     *
      * @param text This parameter assigns the text that will be displayed on the button.
     * @param command This parameter passes information that the service will process.
     *                Give in the format:
     *                String.format("%s|%s|...", CallbackQueryType.UNSUBSCRIBE, [what needs to be sent], ...);
     */
    public InlineButton(String text, String command) {
        this.text = text;
        this.command = command;
        this.url = Optional.empty();
    }

    public InlineButton(String text, String command, String url) {
        this.text = text;
        this.command = command;
        this.url = Optional.of(url);
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public Optional<String> getUrl() {
        return url;
    }
    public void setUrl(Optional<String> url) {
        this.url = url;
    }

}
