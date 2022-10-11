package org.example.headerExchange;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String message ="testtt";

        Map<String , Object> header = new HashMap<>();
        header.put("item1","mobile");
        header.put("item2","television");

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties();

        basicProperties = basicProperties.builder().headers(header).build();

        channel.basicPublish("Header-Exchange" , "",basicProperties , message.getBytes());
        channel.close();
        connection.close();

    }
}
