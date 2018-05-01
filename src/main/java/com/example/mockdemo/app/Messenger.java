package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class Messenger {

	private MessageService ms;
	
	// Constructor with MesegeService implementation
	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	// Messenger class has testConnection method which returns:
	// -> 0 in case of Successful Connection
	// -> 1 otherwise
	public int testConnection(String server) {
		if(ms.checkConnection(server) == ConnectionStatus.SUCCESS)
			return 0;
		else
			return 1;
	}
	
	// sendMessage method should return:
	// 0 send results in case of success
	// 1 when an error occurred 
	// 2 when the message was badly constructed or the server string was wrong
	public int sendMessage(String server, String message) {
		int result = -1;
		try {
			
			SendingStatus sendresult = ms.send(server, message);
			
			if(sendresult == SendingStatus.SENT)
				result = 0;
			if(sendresult == SendingStatus.SENDING_ERROR)
				result = 1;
		}
		catch(MalformedRecipientException e){
			return 2;
		}
		
		return result;
	}
}
