package ua.myCinema.service;

import ua.myCinema.domain.mail.Mail;

public interface EmailService {

	void sendMessage(Mail mail);
	
}
