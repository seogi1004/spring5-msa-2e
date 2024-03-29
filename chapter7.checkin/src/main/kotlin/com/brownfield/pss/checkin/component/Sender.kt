package com.brownfield.pss.checkin.component

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Sender @Autowired
internal constructor(internal var template: RabbitMessagingTemplate) {
    @Bean
    internal fun queue(): Queue {
        return Queue("CheckINQ", false)
    }

    fun send(message: Any) {
        template.convertAndSend("CheckINQ", message)
    }
}