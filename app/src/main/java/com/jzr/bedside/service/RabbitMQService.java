package com.jzr.bedside.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.utils.PreferUtil;
import com.orhanobut.logger.Logger;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * Created by Bben on 2018/11/20.
 */

public class RabbitMQService extends Service {

     private String exchangeName = "fanout.exchange.test";
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.MAIN_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ConnectionFactory factory = new ConnectionFactory();
                    factory.setHost(PreferUtil.getInstance().getRabbitmqIp());
                    factory.setPort(Integer.parseInt(PreferUtil.getInstance().getRabbitmqPort()));
                    factory.setUsername("admin");
                    factory.setPassword("admin");
                    factory.setAutomaticRecoveryEnabled(true); //设置自动恢复连接
                    factory.setNetworkRecoveryInterval(5000); //设置自动连接间隔(毫秒)
                    Connection connection = factory.newConnection();
                    final Channel channel = connection.createChannel();
                    channel.basicQos(0);
                    //声明交换机类型
                    channel.exchangeDeclare(exchangeName, "fanout"); //类型四种:fanout,direct,topic,handers
                    //声明默认的队列
                    String queue = channel.queueDeclare().getQueue();
                    //将队列与交换机绑定,最后一个参数为routingKey,与发送者指定的一样""，fanout交换机类型设置key无效，会发送给设置的队列去匹配
                    channel.queueBind(queue, exchangeName, "");
//                    channel.queueDeclare(PreferUtil.getInstance().getQueueName(), true, false, false, null);

                    while (true){
                        Consumer consumer = new DefaultConsumer(channel) {
                            @Override
                            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                                String message = new String(body, "UTF-8");
                                Logger.e("RecvLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                            }
                        };
//                        channel.basicConsume(PreferUtil.getInstance().getQueueName(), true, consumer);
                        channel.basicConsume(queue, true, consumer);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
