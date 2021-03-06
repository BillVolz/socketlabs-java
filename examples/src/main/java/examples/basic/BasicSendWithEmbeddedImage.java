package examples.basic;

import com.socketLabs.injectionApi.SendResponse;
import com.socketLabs.injectionApi.SocketLabsClient;
import com.socketLabs.injectionApi.message.Attachment;
import com.socketLabs.injectionApi.message.BasicMessage;
import com.socketLabs.injectionApi.message.EmailAddress;
import examples.*;

public class BasicSendWithEmbeddedImage implements Example {

    public SendResponse RunExample ()  throws Exception {

        BasicMessage message = new BasicMessage();

        message.setSubject("Sending An Email With An Embedded Image");
        message.setHtmlBody("<html><body><h1>Sending An Email With An Embedded Image</h1><p>This is the Html Body of my message.</p><h2>Embedded Image:</h2><p><img src=\"cid:bus\" /></p></body></html>");
        message.setPlainTextBody("This is the Plain Text Body of my message.");

        message.setFrom(new EmailAddress("from@example.com"));
        message.addToEmailAddress("recipient1@example.com");

        Attachment attachment = new Attachment(
                "bus.png",
                "image/png",
                "src/main/java/examples/img/bus.png"
        );
        attachment.setContentId("bus");

        message.addAttachments(attachment);

        SocketLabsClient client = new SocketLabsClient(ExampleConfig.ServerId, ExampleConfig.ApiKey);
        SendResponse response =  client.send(message);

        return response;

    }
}