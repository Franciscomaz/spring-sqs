package com.learning.sqs.infrastructure.messaging.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MessageConverter;

public interface Converter {

    @Bean
    MessageConverter getConverter();

}
