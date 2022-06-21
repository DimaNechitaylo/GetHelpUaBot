package ua.charity.GetHelpUaBot.boilerplate;

public class Button {

    private String text;
    private boolean locationButton;
    private boolean contactButton;

    public Button(String text) {
        this.text = text;
    }

    public Button(String text, boolean contactButton, boolean locationButton) {
        this.text = text;
        this.contactButton = contactButton;
        this.locationButton = locationButton;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean isLocationButton() {
        return locationButton;
    }
    public void setLocationButton(boolean locationButton) {
        this.locationButton = locationButton;
    }
    public boolean isContactButton() {
        return contactButton;
    }
    public void setContactButton(boolean contactButton) {
        this.contactButton = contactButton;
    }

}
