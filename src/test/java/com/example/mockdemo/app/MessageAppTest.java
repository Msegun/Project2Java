package com.example.mockdemo.app;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.*;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageAppTest {

	// Messenger messenger = new Messenger();
	// We're going to accept polish servers
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	private Messenger messenger;
	private MessageServiceCustomMock ms;
	
	// Test will be finished later when i create implementation of own fake MessageService
	
	@BeforeEach
	public void setUp(){
		ms = new MessageServiceCustomMock();
		messenger = new Messenger(ms);
	}
	
	// First I'm going to create a few test to check my if fake implementation works as expected
	// These tests were not necessary
	// Testing my custom checkConnection method
	
	// Simple assertTrueExample
	@Test
	public void SetConnectionCheck() {
		ms.SetConnection(true);
		assertTrue(ms.RetConnection());	
	}
	
	// Simple assertFalseExample
	@Test
	public void SetSentheck() {
		ms.SetMessageSent(false);
		assertFalse(ms.RetSent());	
	}
	
	@Test
	public void ConnectionStatusMessageServiceWithValidServerReturnsSuccess() {
		ms.SetConnection(true);
		assertEquals(ConnectionStatus.SUCCESS, ms.checkConnection(VALID_SERVER));	
	}
	
	@Test
	public void ConnectionStatusMessageServiceWithInvalidServerReturnsFailure() {
		ms.SetConnection(true);
		assertEquals(ConnectionStatus.FAILURE, ms.checkConnection(INVALID_SERVER));	
	}
	
	@Test
	public void ConnectionStatusMessageServiceWithValidServerAndFalseConnectionReturnsFailure() {
		ms.SetConnection(false);
		assertEquals(ConnectionStatus.FAILURE, ms.checkConnection(VALID_SERVER));	
	}
	
	@Test
	public void ConnectionStatusMessageServiceWithInValidServerAndFalseConnectionReturnsFailure() {
		ms.SetConnection(false);
		assertEquals(ConnectionStatus.FAILURE, ms.checkConnection(INVALID_SERVER));	
	}
	
	// Testing my custom send method
	@Test
	public void SendMessageServiceWithValidServerSuccess() throws MalformedRecipientException {
		ms.SetMessageSent(true);
		assertEquals(SendingStatus.SENT, ms.send(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void SendMessageServiceWithInValidServiceException() throws MalformedRecipientException {
		assertThrows(MalformedRecipientException.class,
	            ()->{
	            	ms.SetMessageSent(true);
	        		assertEquals(SendingStatus.SENDING_ERROR, ms.send(INVALID_SERVER, VALID_MESSAGE));
	            });
	}
	
	@Test
	public void SendMessageServiceWithInValidMessageException() throws MalformedRecipientException {
		assertThrows(MalformedRecipientException.class,
	            ()->{
	            	ms.SetMessageSent(true);
	        		assertEquals(SendingStatus.SENDING_ERROR, ms.send(VALID_SERVER, INVALID_MESSAGE));
	            });
	}
	
	@Test
	public void SendMessageServiceWithValidMessageAndServerReturnsError() throws MalformedRecipientException {
		ms.SetMessageSent(false);
		assertEquals(SendingStatus.SENDING_ERROR, ms.send(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void SendMessageServiceWithNullMessageOrServerException() throws MalformedRecipientException {
		assertThrows(MalformedRecipientException.class,
	            ()->{
	            	ms.SetMessageSent(true);
	        		assertEquals(SendingStatus.SENDING_ERROR, ms.send(null, null));
	            });
	}
	
	// Testing Messenger Class after checking 
	@Test
	public void TestConnectionWithValidServerReturnsZero() {
		ms.SetConnection(true);
		assertThat(messenger.testConnection(VALID_SERVER), is(0));
	}
	
	@Test
	public void TestConnectionWithNullServerReturnsOne() {
		ms.SetConnection(true);
		assertThat(messenger.testConnection(null), is(1));
	}
	
	@Test
	public void TestConnectionFalseFlagReturnsOne() {
		ms.SetConnection(false);
		assertThat(messenger.testConnection(VALID_SERVER), is(1));
	}
	
	@Test
	public void TestConnectionWithInValidServerReturnsOne() {
		ms.SetConnection(true);
		assertThat(messenger.testConnection(INVALID_SERVER), is(1));
	}
	
	
	// Messenger class Send method tests
	// Hamcrest example of assertThat
	@Test
	public void SendMessageWithValidServerAndMessageReturnsZero() {
		ms.SetMessageSent(true);
		assertThat(messenger.sendMessage(VALID_SERVER, VALID_MESSAGE), is(0));
	}
	
	@Test
	public void SendMessageWithValidServerAndMessageReturnsOneWithFalseFlag() {
		ms.SetMessageSent(false);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	// If the Server name is wrong or message is wrong we should get 2
	@Test
	public void testMessengerSendMessageWithInValidServerAndValidMessageReturnsTwo() {
		ms.SetMessageSent(true);
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void SendMessageWithValidServerAndInValidMessageReturnsTwo() {
		ms.SetMessageSent(true);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void SendMessageWithInValidServerAndInValidMessageReturnsTwo() {
		ms.SetMessageSent(true);
		assertThat(messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE), is(2));
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		messenger = null;
		ms = null;
	}
}
