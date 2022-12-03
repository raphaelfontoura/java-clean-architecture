package br.com.alura.infra.indicacao;

import br.com.alura.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.dominio.aluno.Aluno;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    static final String FROM = "noreply@aluraescola.com.br";
    static final String SMTP_USERNAME = "escola@aluraescola.com.br";
    static final String SMTP_PASSWORD = "escola123";
    static final String HOST = "smtp.gmail.com";
    static final int PORT = 465;

    @Override
    public void enviarPara(Aluno aluno) {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", PORT);

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SMTP_USERNAME,SMTP_PASSWORD);
                    }
                });

        /** Ativa Debug para sessão */
        //session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(aluno.getEmail());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Enviando email com JavaMail");//Assunto
            message.setText("Enviando um email para o aluno cadastrado.");
            /**Método para enviar a mensagem criada*/
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
