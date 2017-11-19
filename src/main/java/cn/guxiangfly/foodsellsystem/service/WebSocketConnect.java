package cn.guxiangfly.foodsellsystem.service;



import lombok.extern.slf4j.Slf4j;
import okhttp3.WebSocket;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * WebSocketEndPoint
 *
 * @author guxiang
 * @date 2017/11/19
 */
@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocketConnect {

    private Session session;

    private static CopyOnWriteArraySet<WebSocketConnect> webSocketSet = new CopyOnWriteArraySet<>();


    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
    }

    @OnClose
    public void onClose(Session session){
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocketConnect webSocketConnect: webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocketConnect.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
