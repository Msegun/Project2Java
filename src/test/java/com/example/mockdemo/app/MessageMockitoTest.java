package com.example.mockdemo.app;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

@SuppressWarnings("deprecation")
@ExtendWith(MockitoExtention.class) // Using own implementation of MockitoExcencion.class
public class MessageMockitoTest {
	
	@Mock
	private MessageService ms;
	private Messenger messenger;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	
	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@BeforeEach
	public void setUp() {
		messenger = new Messenger(ms);
	}
	// Verify is a cool little 'assertion' that checks if a certain method occurred
	// I call it an 'assertion' because it also can fail test if method did not occur
	@Test
	public void testConnectionWithValidServerReturnZero() {
		when(ms.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		assertThat(messenger.testConnection(VALID_SERVER)).isZero();
		verify(ms).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testConnectionWithNullReturnOne() {
		when(ms.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		assertThat(messenger.testConnection(null)).isEqualTo(1);
		verify(ms).checkConnection(null);
		// moMoreInteractions checks if previous verify was only one to occur 
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void testConnectionWithInValidReturnOne() {
		when(ms.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertThat(messenger.testConnection(INVALID_SERVER)).isEqualTo(1);
		verify(ms).checkConnection(INVALID_SERVER);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithValidReturnZero() throws MalformedRecipientException {
		when(ms.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE)).isEqualTo(0);
		verify(ms).send(VALID_SERVER, VALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithValidReturnOne() throws MalformedRecipientException {
		when(ms.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE)).isEqualTo(1);
		verify(ms).send(VALID_SERVER, VALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithInValidReturnTwoException() throws MalformedRecipientException {
		when(ms.send(INVALID_SERVER, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE)).isEqualTo(2);
		verify(ms).send(INVALID_SERVER, VALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithNullReturnTwoException() throws MalformedRecipientException {
		when(ms.send(null, null)).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(null, null)).isEqualTo(2);
		verify(ms).send(null, null);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithBothInvalidTwoException() throws MalformedRecipientException {
		when(ms.send(INVALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE)).isEqualTo(2);
		verify(ms).send(INVALID_SERVER, INVALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithInvalidMessageTwoException() throws MalformedRecipientException {
		when(ms.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE)).isEqualTo(2);
		verify(ms).send(VALID_SERVER, INVALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageWithnullServerAndValidMessageTwoException() throws MalformedRecipientException {
		when(ms.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertThat(messenger.sendMessage(null, VALID_MESSAGE)).isEqualTo(2);
		verify(ms).send(null, VALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@Test
	public void sendMessageNegativeResult() throws MalformedRecipientException {
		when(ms.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(null);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE)).isEqualTo(-1);
		verify(ms).send(VALID_SERVER, VALID_MESSAGE);
		verifyNoMoreInteractions(ms);
	}
	
	@AfterEach
	public void drop() {
		messenger = null;
	}
	
}
