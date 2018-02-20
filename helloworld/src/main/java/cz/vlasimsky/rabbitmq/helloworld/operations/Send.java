package cz.vlasimsky.rabbitmq.helloworld.operations;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    public static final String QUEUE_NAME = "hello";
    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        boolean durable = false;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        Thread.sleep(2000);
        for (int i = 1; i <= 1000 ; i++) {
            final String message = "Hello World! - " + i;
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println("[x] Sent '" + message + "'" );
           // Thread.sleep(100);
        }
        System.out.println("DONE");

        channel.close();
        connection.close();
    }
}

