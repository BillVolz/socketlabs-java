package examples.basic;

import com.socketLabs.injectionApi.*;
import com.socketLabs.injectionApi.core.*;
import com.socketLabs.injectionApi.message.*;
import examples.*;

public class BasicAsync implements Example {

    @Override
    public SendResponse RunExample() throws Exception {

        BasicMessage message = new BasicMessage();

        message.setSubject("Sending A Test Message (Basic Send Async)");
        message.setHtmlBody("<html><body><h1>Sending A Test Message</h1><p>This is the Html Body of my message.</p></body></html>");
        message.setPlainTextBody("This is the Plain Text Body of my message.");

        message.setFrom(new EmailAddress("from@example.com"));
        message.addToEmailAddress("david.schrenker@socketlabs.com");

        // create the client
        SocketLabsClient client = new SocketLabsClient(ExampleConfig.ServerId, ExampleConfig.ApiKey);

        // send the message
        client.sendAsync(message, new HttpCallback() {

            @Override
            public void onError(Exception ex)  {
                // Handle Exception here
                return;
            }

            @Override
            public void onResponse(SendResponse response)  {
                // Handle SendResponse here
                return;
            }
        });

        return null;

    }
}
