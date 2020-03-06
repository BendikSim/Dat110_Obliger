package no.hvl.dat110.messages;

// message sent from client to subscribe on a topic
public class SubscribeMsg extends Message {

    private String topic;

    // Constructor
    public SubscribeMsg(String user, String topic) {
        super(MessageType.SUBSCRIBE, user);
        this.topic = topic;
    }

    //get/set-methods

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // toString method


    @Override
    public String toString() {
        return "SubscribeMsg{topic='" + topic + '\'' + '}';
    }
}
