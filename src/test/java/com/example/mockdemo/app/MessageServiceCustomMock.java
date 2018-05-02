package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageServiceCustomMock implements MessageService {

	private boolean connected = false;
	private boolean sent = false;
	
	@Override
	public ConnectionStatus checkConnection(String server) {
		if(server != null && server.endsWith(".pl") && connected)
			return ConnectionStatus.SUCCESS;
		else
			return ConnectionStatus.FAILURE;
			
	}

	@Override
	public SendingStatus send(String server, String message) throws MalformedRecipientException {
		
		if(server == null || message == null)
			throw new MalformedRecipientException();
		// Wrong message -> too short
		if(message.length() < 4)
			throw new MalformedRecipientException();
		// Wrong server -> does not end with ".pl"
		if(!server.endsWith(".pl"))
			throw new MalformedRecipientException();
		
		if (sent)
			return SendingStatus.SENT;
		
		return SendingStatus.SENDING_ERROR;
	}
	
	public void SetConnection(boolean state) {
		connected = state;
	}
	
	public boolean RetConnection() {
		return connected;
	}
	
	
	public void SetMessageSent(boolean state) {
		sent = state;
	}

	public boolean RetSent() {
		return sent;
	}
}
