package attendance.manas.edu.kg.controller;

import attendance.manas.edu.kg.model.FingerImage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public FingerImage sendMessage(@Payload FingerImage fingerImage) {
        return fingerImage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public FingerImage addUser(@Payload FingerImage fingerImage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("id", fingerImage.getId());
        return fingerImage;
    }
}
