package messages;

public class MessageBox {
    int index = 0;
    int index2 = 0;
    private int messageId;
    private String messageSent[] = new String[500];
    private String senderUsername[] = new String[500];

    public String[] getMessageSent() {
        return messageSent;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setMessageSent(String messageSent) {
        this.messageSent[index2] = messageSent;
        index2++;
    }

    public String[] getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername[index] = senderUsername;
        index++;
    }
}
