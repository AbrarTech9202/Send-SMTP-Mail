package com.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.maildto.MailRequestDto;
import com.mail.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	 
	@Autowired
	private MailService mailService;
	
	@PostMapping("/sendmail")
	public String mailSender(@RequestBody MailRequestDto mailRequestDto)
	{
		return mailService.mailSender(mailRequestDto);
	}

	@PostMapping("/sendAttachment")
	public String sendAttachment( @RequestBody MailRequestDto mailRequestDto)
	{
		return mailService.atachedMent(mailRequestDto);
	}
	
}
