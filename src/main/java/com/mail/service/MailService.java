package com.mail.service;

import com.mail.maildto.MailRequestDto;

public interface MailService {
	
	String mailSender(MailRequestDto mailRequestDto);
    String atachedMent(MailRequestDto mailRequestDto);
	
}
