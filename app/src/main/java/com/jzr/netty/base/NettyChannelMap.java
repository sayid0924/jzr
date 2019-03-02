package com.jzr.netty.base;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyChannelMap {
    public static Map<String, SocketChannel> map = new ConcurrentHashMap<String, SocketChannel>();

    public static void add(String clientId, SocketChannel socketChannel) {
        map.put(clientId, socketChannel);
    }

    public static Channel get(String clientId) {
        if (map == null || map.size() == 0) {
            return null;
        }
        return map.get(clientId);
    }

    public static int remove(SocketChannel socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                System.out.println("remove channel:" + entry.getKey().toString());
                map.remove(entry.getKey());
                return 1;
            }
        }
        return 0;
    }
}