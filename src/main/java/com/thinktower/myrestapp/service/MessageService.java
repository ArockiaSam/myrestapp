package com.thinktower.myrestapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.thinktower.myrestapp.exception.LimitExceedException;
import com.thinktower.myrestapp.model.Message;

public interface MessageService {

	public ResponseEntity<String> newMessage(Message message) throws LimitExceedException;
	
	public List<Message> listMessage();
}
