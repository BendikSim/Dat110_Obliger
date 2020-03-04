package no.hvl.dat110.messages;

// message sent from client to unsubscribe on a topic
public class UnsubscribeMsg extends Message {

    private String topic;

    // Constructor
    public UnsubscribeMsg(String user, String topic) {
        super(MessageType.UNSUBSCRIBE, user);
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
        return "UnsubscribeMsg{topic='" + topic + '\'' + '}';
    }
	
}
