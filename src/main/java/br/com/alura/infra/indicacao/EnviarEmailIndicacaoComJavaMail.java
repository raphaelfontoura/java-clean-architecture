package br.com.alura.infra.indicacao;

import br.com.alura.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.dominio.aluno.Aluno;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    final String username = "seuemail@gmail.com";
    final String password = "aaaabbbbccccdddd"; //seu password gerado para api no google

    @Override
    public void enviarPara(Aluno aluno) {
        Properties prop = new Properties();
        /**
         Outgoing Mail (SMTP) Server
         requires TLS or SSL: smtp.gmail.com (use authentication)
         Use Authentication: Yes
         Port for SSL: 465
         */
        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        prop.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        prop.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        prop.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        prop.put("mail.smtp.port", "465"); //SMTP Port


        /**
         Outgoing Mail (SMTP) Server
         requires TLS or SSL: smtp.gmail.com (use authentication)
         Use Authentication: Yes
         Port for TLS/STARTTLS: 587
         */
//        prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//        prop.put("mail.smtp.port", "587"); //TLS Port
//        prop.put("mail.smtp.auth", "true"); //enable authentication
//        prop.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getDefaultInstance(prop, auth);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("raphael.fontoura@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(aluno.getEmail())
            );
            message.setSubject("Testing Gmail Javax");
            message.setText("Aluno, " + aluno.getNome()
                    + "\n\n Sua indicação ocorreu com sucesso.");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
