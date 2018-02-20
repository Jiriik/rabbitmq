package cz.vlasimsky.rabbitmq.helloworld.operations;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static cz.vlasimsky.rabbitmq.helloworld.operations.Send.QUEUE_NAME;

public class Receive {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Send.HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        boolean durable = false;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        int prefetchCount = 1; //number of messages to be fetched from the server
        channel.basicQos(prefetchCount);
        System.out.println("[x] Waiting for messages. To exit pres CTRL+C.");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("[x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);


    }

    private static void doWork(String message) throws InterruptedException {
        for (char ch: message.toCharArray()) {
            if ((int) ch % 2 == 0) {
                Thread.sleep(100);
            }
        }
    }
}
