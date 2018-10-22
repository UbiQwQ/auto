package com.innovation.auto.config;

import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Auther: Innovation
 * @Date: 2018/9/26 22:27
 * @Description:
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {



    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //点对点应配置一个/user消息代理，广播式应配置一个/topic消息代理
        config.enableSimpleBroker("/topic","/user");
//        config.setApplicationDestinationPrefixes("/app");
        //点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        config.setUserDestinationPrefix("/user/");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
    }

//
//    /**
//     * 配置消息代理
//     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
//     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");//推送消息前缀
//        config.setApplicationDestinationPrefixes("/app");//应用请求前缀
//        config.setUserDestinationPrefix("/user");//推送用户前缀
//    }
//
//    /***
//     * 注册 Stomp的端点
//     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
//     * withSockJS：使用SockJS协议
//     * @param registry
//     */
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/gs-guide-websocket")
//                .setAllowedOrigins("*")//添加允许跨域访问
//                .withSockJS();
//    }



//    /***
//     * 注册 Stomp的端点
//     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
//     * withSockJS：使用SockJS协议
//     * @param registry
//     */
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/api/v1/socket")
//                .setAllowedOrigins("*")//添加允许跨域访问
//                .withSockJS() ;
//    }
//
//    /**
//     * 配置消息代理
//     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
//     */
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/api/v1/socket/send","/user/");//推送消息前缀
//        registry.setApplicationDestinationPrefixes("/api/v1/socket/req");//应用请求前缀
//        registry.setUserDestinationPrefix("/user");//推送用户前缀
//
////        registry.enableSimpleBroker("/topic","/user");
////        registry.setUserDestinationPrefix("/user/");
////        registry.setApplicationDestinationPrefixes("/app");//走@messageMapping
//    }

}