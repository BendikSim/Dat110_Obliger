package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {

    private String topic;

    // Constructor
    public CreateTopicMsg(String topic, String user) {
        super(MessageType.CREATETOPIC, user);
        this.topic = topic;
    }


    // message sent from client to create topic on the broker
    
    // get/set-methods
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // toString method
    @Override
    public String toString() {
        return "CreateTopicMsg{" + "topic='" + topic + '}';
    }
}
