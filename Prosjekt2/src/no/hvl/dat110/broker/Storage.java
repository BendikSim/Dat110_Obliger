package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	// add corresponding client session to the storage
	public void addClientSession(String user, Connection connection) {
		ClientSession session = new ClientSession(user, connection);
		if(!clients.containsKey(user)){
			clients.put(user, session);
		}

	}

	// remove client session for user from the storage
	public void removeClientSession(String user) {
		if(clients.containsKey(user)) {
			clients.remove(user);
		}
	}

	// create topic in the storage
	public void createTopic(String topic) {
		if(!subscriptions.containsKey(topic)) {
			Set<String> subscribers = ConcurrentHashMap.newKeySet();
			subscriptions.put(topic, subscribers);
		}
	}

	// delete topic from the storage
	public void deleteTopic(String topic) {

		if(subscriptions.containsKey(topic)) {
			subscriptions.remove(topic);
		}
	}

	// add the user as subscriber to the topic
	public void addSubscriber(String user, String topic) {

		if(subscriptions.containsKey(topic)) {
			Set<String> hashset = subscriptions.get(topic);
			if(!hashset.contains(user)){
				hashset.add(user);
			}
		}
	}

	// remove the user as subscriber to the topic
	public void removeSubscriber(String user, String topic) {

		if(subscriptions.containsKey(topic)) {
			Set<String> subscribers = subscriptions.get(topic);
			if(subscribers.contains(user)) {
				subscribers.remove(user);
			}
		}
	}
}
