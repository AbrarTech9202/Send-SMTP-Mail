package com.mail.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mail.maildto.MailRequestDto;
import com.mail.service.MailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	static String responseMail;
	public String mailSender(MailRequestDto mailRequestDto) {
		
		try {

			String to = mailRequestDto.getTo();
			String from = mailRequestDto.getFrom();
			String subject = mailRequestDto.getSubject();

			MimeMessage massage = javaMailSender.createMimeMessage();
			MimeMessageHelper massageHelper = new MimeMessageHelper(massage, true);
			massageHelper.setTo(to);
			massageHelper.setFrom(from);
			massageHelper.setSubject(subject);
			massageHelper.setText(subject, true);
			javaMailSender.send(massage);

			responseMail = "successfully email sent 😊😊😊...";

		} catch (Exception e) {

			responseMail = "mail not sent 😲😲😲..";
			e.printStackTrace();
		}
		return responseMail;

	}

	@Override
	public String atachedMent(MailRequestDto mailRequestDto) {

		
		try {
			
			String to = mailRequestDto.getTo();
			String from = mailRequestDto.getFrom();
			String subject = mailRequestDto.getSubject();

			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setTo(to);
			helper.setFrom(from);
			helper.setSubject(subject);
			helper.setText(subject, true);
			
			helper.addAttachment("image.jpg", new File("D:\\Attachment\\image.jpg"));
			javaMailSender.send(message);
			
			responseMail= "Successfull sent email 😊😊😊...";
		} catch (Exception e) {
  
			responseMail="mail not sent 🙄🙄🙄... ";
			e.printStackTrace();
			
		}
      return responseMail;
	}
}
