package com.innovation.auto.controller;

import com.innovation.auto.model.Greeting;
import com.innovation.auto.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.Random;


/**
 * @Auther: Innovation
 * @Date: 2018/9/26 22:34
 * @Description:
 */
@Controller
public class GreetingController {
    // boot自动配置
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
//    /**session操作类*/
//    @Autowired
//    SocketSessionRegistry webAgentSessionRegistry;

//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public String greeting() throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return "Hello SpringBoot WebSocket...";
//    }


    /**
     * 向订阅/topic/greetings 推送消息
     * @throws Exception
     */
//    @Scheduled(fixedRate = 1000)
//    public void greeting1() throws Exception {
//        messagingTemplate.convertAndSend("/topic/greetings", "Hello SpringBoot WebSocket...");
//    }
//
//
//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }

//    @MessageMapping("/welcome")
//    public ResponseMessage toTopic(RequestMessage msg) throws Exception
//    {
//        System.out.println("======================"+msg.getMessage());
//        this.messagingTemplate.convertAndSend("/api/v1/socket/send",msg.getMessage());
//        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
//    }
//
//    @MessageMapping("/message")
//    public ResponseMessage toUser(RequestMessage msg ) {
//        System.out.println(msg.getMessage());
//        this.messagingTemplate.convertAndSendToUser("123","/message",msg.getMessage());
//        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
//    }


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


//    /**
//     * 向订阅/topic/prepare 推送消息[广播]
//     * @throws Exception
//     */
//    @Scheduled(fixedRate = 1000)
//    public void greeting1() throws Exception {
//        Random random = new Random();
//        int randomInt = random.nextInt(10);
//        messagingTemplate.convertAndSend("/topic/prepare", new Greeting("Hello,Scheduled... !" + randomInt));
//    }

    @Scheduled(fixedRate = 1000)
    public void greeting1() throws Exception {
        HelloMessage message = new HelloMessage("1");
        Random random = new Random();
        int randomInt = random.nextInt(10);
        messagingTemplate.convertAndSendToUser("1","/prepare", new Greeting("Hello,Scheduled... !" + randomInt));
        messagingTemplate.convertAndSendToUser("2","/prepare", new Greeting("Hello,Scheduled... !" + randomInt));
    }


    /**
     * 向订阅/topic/prepare 推送消息[单播]
     * @throws Exception
     */
//    @Scheduled(fixedRate = 1000)
//    public void greeting2() throws Exception {
//        Random random = new Random();
//        int randomInt = random.nextInt(10);
////        String sessionId=webAgentSessionRegistry.getSessionIds(message.getId()).stream().findFirst().get();
//        messagingTemplate.convertAndSendToUser("1","/topic/prepare", new Greeting("Hello,Scheduled... !" + randomInt));
//    }

}
