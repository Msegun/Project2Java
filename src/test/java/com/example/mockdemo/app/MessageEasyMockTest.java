package com.example.mockdemo.app;

import org.easymock.Mock;
import org.easymock.MockType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; //uzywam JUnit5!!!
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


@ExtendWith(EasyMockExtention.class)
public class MessageEasyMockTest {
	
	private Messenger messenger;
	
	@Mock(type = MockType.NICE)
	private MessageService ms;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	// Few tests in easyMock in jUnit5
	
	@BeforeEach
	public void setUp() {
		ms = mock(MessageService.class);
		messenger = new Messenger(ms);
	}
	
	@Test
	public void testConnectionWithValidServerReturnsZero() {
		expect(ms.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(ms);
		assertThat(messenger.testConnection(VALID_SERVER)).isZero();
		verify(ms);
	}
	
	@Test
	public void testConnectionWithInValidServerReturnsOne() {
		expect(ms.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(ms);
		assertThat(messenger.testConnection(INVALID_SERVER)).isSameAs(1);
		verify(ms);
	}
	
	@Test
	public void testConnectionWithNullReturnsOne() {
		expect(ms.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		replay(ms);
		assertThat(messenger.testConnection(null)).isSameAs(1);
		verify(ms);
	}
	
	@Test
	public void sendMessageWithValidInputReturnsZero() throws MalformedRecipientException {
		expect(ms.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		replay(ms);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE)).isZero();
		verify(ms);
	}
	
	@Test
	public void sendMessageWithValidInputReturnsOne() throws MalformedRecipientException {
		expect(ms.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(ms);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE)).isSameAs(1);
		verify(ms);
	}
	
	@Test
	public void sendMessageWithInValidInputReturnsTwo() throws MalformedRecipientException {
		expect(ms.send(INVALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(ms);
		assertThat(messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE)).isSameAs(2);
		verify(ms);
	}
	
	
	@Test
	public void sendMessageWithInValidServerInputReturnsTwo() throws MalformedRecipientException {
		expect(ms.send(INVALID_SERVER, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(ms);
		assertThat(messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE)).isSameAs(2);
		verify(ms);
	}
	
	@Test
	public void sendMessageWithInValidMessageInputReturnsTwo() throws MalformedRecipientException {
		expect(ms.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(ms);
		assertThat(messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE)).isSameAs(2);
		verify(ms);
	}
	
	@Test
	public void sendMessageWithNullInputReturnsTwo() throws MalformedRecipientException {
		expect(ms.send(null, null)).andThrow(new MalformedRecipientException());
		replay(ms);
		assertThat(messenger.sendMessage(null, null)).isSameAs(2);
		verify(ms);
	}
	
	@AfterEach
	public void tearDown() {
		messenger = null;
		ms = null;
	}

}