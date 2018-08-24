/**
 * 
 */
package com.thinktower.myrestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinktower.myrestapp.exception.LimitExceedException;
import com.thinktower.myrestapp.model.Message;
import com.thinktower.myrestapp.service.MessageService;

@RestController
@RequestMapping("/myrestapp")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@PostMapping("/post")
	public ResponseEntity<String> newMessage(@RequestBody Message message) throws LimitExceedException {
		return messageService.newMessage(message);
	}

	@GetMapping("/home")
	public List<Message> listMessage() {
		return messageService.listMessage();
	}

	

	
}
