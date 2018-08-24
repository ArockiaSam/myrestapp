/**
 * 
 */
package com.thinktower.myrestapp.model;

import java.util.Date;

public class Message {

	private String message;

	private Date date = new Date();

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
