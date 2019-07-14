package com.learning.sqs.infrastructure.messaging.listener;

import org.springframework.stereotype.Component;

@Component
public interface Receiver<T> {

    void onMessage(final T message);

}
