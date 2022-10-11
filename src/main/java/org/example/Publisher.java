package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//        String message = "salam dash javad";

//        String[] messages = {"first", "second", "third", "fourth"};
//        for (String message : messages) {
//            channel.basicPublish("", "Queue-1", null, message.getBytes());
//
//        }
//        channel.close();
//        connection.close();


        JSONObject json = new JSONObject();
        json.put("from", "javad");
        json.put("to", "ali");
        json.put("email", "xyz@gmail.com");

        channel.basicPublish("", "my-queue", null, json.toString().getBytes());

        channel.close();
        connection.close();
    }
}
