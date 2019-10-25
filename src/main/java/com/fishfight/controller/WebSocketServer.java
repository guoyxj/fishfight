package com.fishfight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    private static AtomicLong onlineCount = new AtomicLong(0);
    private static Map<String,WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    private Session session;
    private String sid;

    @OnOpen
    public void onOpen(Session session, @PathParam("sid")String sid) {
        logger.info("建立webSocket链接 sid={}",sid);
        this.session = session;
        this.sid = sid;
        webSocketSet.put(sid,this);
        onlineCount.incrementAndGet();
        sendMessage("连接成功");
    }

    @OnClose
    public void onClose() {
        logger.info("webSocket disconnect,sid={}",sid);
        webSocketSet.remove(sid);  //从set中删除
        onlineCount.decrementAndGet();
    }

    @OnMessage
    public void onMessage(String message, Session session) {

    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("webSocket work error",error);
    }

    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.error("webSocket send msg fail",e);
        }
    }

    public static void sendToUser(String message,String sid){
        Optional.ofNullable(webSocketSet.get(sid)).ifPresent(webSocketServer -> webSocketServer.sendMessage(message));
    }
}
