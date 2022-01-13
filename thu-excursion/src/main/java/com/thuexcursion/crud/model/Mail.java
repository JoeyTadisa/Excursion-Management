package com.thuexcursion.crud.model;


public class Mail {
	private String recipient;
    private String subject;
    private String message;
	private String reply_to;
	
	public Mail() {
    }

	public Mail(String recipient, String subject, String message, String reply_to) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
		this.reply_to = reply_to;
    }

	public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getReplyTo() {
        return reply_to;
    }

    public void setReplyTo(String reply_to) {
        this.reply_to = reply_to;
    }

}
