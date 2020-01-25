package messages;

public class MessageBox {
    int index = 0;
    int index2 = 0;
    private String messageSent[] = new String[500];
    private String receiverUsername[] = new String[500];

    public String[] getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(String messageSent) {
        this.messageSent[index2] = messageSent;
        index2++;
    }

    public String[] getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername[index] = receiverUsername;
        index++;
    }
}
