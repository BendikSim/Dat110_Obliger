package no.hvl.dat110.messages;

// message sent from client to create publish a message on a topic
public class PublishMsg extends Message {

    private String topic;
    private String message;

    // Constructor
    public PublishMsg(String user, String topic, String message) {
        super(MessageType.PUBLISH, user);
        this.topic = topic;
        this.message = message;
    }

    // Get/Set methods
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // toString
    @Override
    public String toString() {
        return "PublishMsg{" +
                "topic='" + topic +
                ", message='" + message +  ", user=" + getUser() + '}';
    }




	
}
