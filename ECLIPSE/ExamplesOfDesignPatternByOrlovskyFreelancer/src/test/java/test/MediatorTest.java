package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mediatorexample.ChatRoom;
import mediatorexample.User;

class MediatorTest {

	private ChatRoom chatroomObj;
	private User userObj;

	@BeforeEach
	public void setUp() {
		chatroomObj = new ChatRoom();
		userObj = new User("John");
	}

	@Test
	public void checkIfChatRoomCanBeCreated() {
		assertNotNull(chatroomObj);
	}

	@Test
	public void checkIfUserCanBeCreated() {
		assertNotNull(userObj);
	}

	@Test
	public void showMediatorPatternRunning() {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}
}
