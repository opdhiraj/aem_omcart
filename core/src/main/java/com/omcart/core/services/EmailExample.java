package com.omcart.core.services;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.Component;
import java.util.List;


@Component(immediate = true)

public class EmailExample {

    @Reference
    private MessageGatewayService messageGatewayService;


    public void sendEmail(List<String> recipients) throws EmailException {

        MessageGateway<HtmlEmail> messageGateway = messageGatewayService.getGateway(HtmlEmail.class);

        HtmlEmail email = new HtmlEmail();
        for(String recipient : recipients){
            email.addTo(recipient);
        }
        email.setTextMsg("Hello World!");
        messageGateway.send(email);
    }
}

