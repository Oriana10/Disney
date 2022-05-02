package com.disney.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class MyMailSender {

	@Autowired
	private JavaMailSender myMailSender;

	public void enviarMail(String nombre, String mail, String mensaje) throws Exception {

		try {
			SimpleMailMessage message1 = new SimpleMailMessage();
			message1.setFrom("examplefelgnoreply@gmail.com");
			message1.setTo("examplefelgnoreply@gmail.com");
			message1.setSubject("Consulta via Web Recibida");
			message1.setText(nombre + ", cuyo mail es " + mail + ", envió el siguiente mensaje: " + mensaje);
			myMailSender.send(message1);

			SimpleMailMessage message2 = new SimpleMailMessage();
			message2.setFrom("examplefelgnoreply@gmail.com");
			message2.setTo(mail);
			message2.setSubject("¡Bienvenido a la DisneyAPP!");
			message2.setText("Gracias " + nombre + " por visitarnos, esperamos que disfrute de nuestra página");
			myMailSender.send(message2);
		} catch (Exception e) {
			throw e;
		}

	}
}
