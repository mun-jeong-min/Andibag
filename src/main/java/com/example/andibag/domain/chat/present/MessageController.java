package com.example.andibag.domain.chat.present;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@RestController
@ServerEndpoint("/websocket")
public class MessageController extends Socket {
    private static final List<Session> session = new ArrayList<Session>();

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        for (int i = 0; i < session.size(); i++) {
            if (!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText("상대 : " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    session.get(i).getBasicRemote().sendText("나 : " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}