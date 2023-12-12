package config;

import chat.ChatMessage;
import chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

    @Component
    @RequiredArgsConstructor
    @Slf4j //logging information when user leave the chart
    @Log

    public class WebSocketEventListener {

        @EventListener
    public void HandleWebSocketDiconnectListener(SessionDisconnectEvent event)
            {
                StompHeaderAccessor headerAccessor =StompHeaderAccessor.wrap(event.getMessage());
                String username=(String) headerAccessor.getSessionAttributes().get("username");
           if (username != null){
               System.out.println("user disconnected :{}" +  username);
               var chatMessage = ChatMessage.builder()
                       .type(MessageType.LEAVE).build();
              // log.info("user disconnected :{}" , username);
           }

            }

    }
