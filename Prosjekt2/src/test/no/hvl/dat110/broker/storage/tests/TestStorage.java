package test.no.hvl.dat110.broker.storage.tests;


import no.hvl.dat110.broker.Storage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.Set;



public class TestStorage {

	protected Storage storage;
	private static String TESTUSER = "testuser";
	private static String TESTTOPIC = "testtopic";
	
	@Before
	public void setUp() throws Exception {
		storage = new Storage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddClientSession() {
		
		storage.addClientSession(TESTUSER, null);
		
		assertEquals(storage.getSessions().size(),1);
		
		Assert.assertNotEquals(storage.getSession(TESTUSER),null);
	
	}
	
	@Test
	public void testremoveClientSession() {

		System.out.println("TEST");
		storage.addClientSession(TESTUSER, null);
		
		assertEquals(storage.getSessions().size(),1);
		
		Assert.assertNotEquals(storage.getSession(TESTUSER),null);

		storage.removeClientSession(TESTUSER);
	
		assertEquals(storage.getSessions().size(),0);
		
		Assert.assertEquals(storage.getSession(TESTUSER),null);
	}

	private void assertEquals(int size, Object i) {
	}

	@Test
	public void testcreateTopic () {
		
		storage.createTopic(TESTTOPIC);
		
		Set<String> topics = storage.getTopics();
		
		assertEquals(topics.size(),1);

		Assert.assertTrue(topics.contains(TESTTOPIC));
	}
	
	@Test
	public void testdeleteTopic () {
		
		storage.createTopic(TESTTOPIC);
		
		storage.deleteTopic(TESTTOPIC);
		
		assertEquals(storage.getTopics().size(),0);
		
	}

	@Test
	public void testaddSubscriber () {
		
		storage.createTopic(TESTTOPIC);
		
		storage.addSubscriber(TESTUSER, TESTTOPIC);
		
		Set<String> subscribers = storage.getSubscribers(TESTTOPIC);
		
		assertEquals(subscribers.size(),1);
		
		Assert.assertTrue(subscribers.contains(TESTUSER));
		
	}
	
	@Test
	public void testaddSubscribers () {
		
		String TESTUSER1 = TESTUSER+"1";
		String TESTUSER2 = TESTUSER+"2";
		
		storage.createTopic(TESTTOPIC);
		storage.createTopic(TESTTOPIC+"1");
		
		storage.addSubscriber(TESTUSER1, TESTTOPIC);
		storage.addSubscriber(TESTUSER2, TESTTOPIC);
		
		Set<String> subscribers = storage.getSubscribers(TESTTOPIC);
		
		assertEquals(subscribers.size(),2);
		
		Assert.assertTrue(subscribers.contains(TESTUSER1));
		Assert.assertTrue(subscribers.contains(TESTUSER2));
		
	}
	
	@Test
	public void testremoveSubscribers () {
	
		String TESTUSER1 = TESTUSER+"1";
		String TESTUSER2 = TESTUSER+"2";
		
		storage.createTopic(TESTTOPIC);
		
		storage.addSubscriber(TESTUSER1, TESTTOPIC);
		storage.addSubscriber(TESTUSER2, TESTTOPIC);
		
		storage.removeSubscriber(TESTUSER2, TESTTOPIC);
		
		Set<String> subscribers = storage.getSubscribers(TESTTOPIC);
		
		assertEquals(subscribers.size(),1);
		
		Assert.assertTrue(subscribers.contains(TESTUSER1));
		Assert.assertFalse(subscribers.contains(TESTUSER2));
		
	}
	
}
