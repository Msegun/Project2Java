package com.example.mockdemo.messenger;

// Our base interface of MessageService
public interface MessageService {
		
	ConnectionStatus checkConnection(String server);
	
	SendingStatus send(String server, String message) throws MalformedRecipientException;

}
