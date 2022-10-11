package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody());
//
//            System.out.println("received message is :  " + message);
//
//        };
//        channel.basicConsume("Queue-1", true, deliverCallback, consumerTag -> {
//        });


        DeliverCallback deliverCallback = (consumerTag, delivery) ->
        {
            String message = new String(delivery.getBody());
            JSONObject jsonObject = new JSONObject(message);
            System.out.println(jsonObject.toMap());

        };

        channel.basicConsume("my-queue", true, deliverCallback, consumerTag -> {
        });





    }
}
