package com.thinktower.myrestapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thinktower.myrestapp.exception.ErrorResponse;
import com.thinktower.myrestapp.exception.LimitExceedException;
import com.thinktower.myrestapp.model.Message;
import com.thinktower.myrestapp.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	private static List<Message> posts;

	public MessageServiceImpl() {
		posts = new ArrayList<>();
		generateDummyData();
	}

	@SuppressWarnings("deprecation")
	private void generateDummyData() {
		posts.add(new Message("Data", new Date("08/22/2018")));
		posts.add(new Message("Data", new Date("08/23/2018")));
		posts.add(new Message("Data", new Date("08/20/2018")));
		posts.add(new Message("Data", new Date("08/21/2018")));
	}
	
	@ExceptionHandler(LimitExceedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> newMessage(Message message) throws LimitExceedException {
		if (message.getMessage().length() > 249) {
			throw new LimitExceedException("Text message length should not exceed 249 characters");
		}
		posts.add(message);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@Override
	public List<Message> listMessage() {
		Collections.sort(posts, new Comparator<Message>() {
			@Override
			public int compare(Message message1, Message message2) {
				Long time1 = message1.getDate().getTime();
				Long time2 = message2.getDate().getTime();
				int value = time1.compareTo(time2); 
				return (value);
			}
		});		
		return posts;
	}

}
