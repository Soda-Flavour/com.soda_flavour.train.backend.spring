package com.soda_flavour.train.rabbit_mq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ApplicationMessageQueueConfig {
	
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

	private @Value("${com.soda_flavour.train.rabbit_mq.exchange}") String exchange;
	private @Value("${com.soda_flavour.train.rabbit_mq.inbound}") String inbound;

    
	@Bean public TopicExchange api() { return new TopicExchange(exchange); }

    @Bean public Queue mi(){ return new Queue(inbound);}
    @Bean public Binding miBinding(){return BindingBuilder.bind(mi()).to(api()).with(inbound);}

  
}