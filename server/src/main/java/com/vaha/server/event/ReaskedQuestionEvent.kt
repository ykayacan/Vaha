package com.vaha.server.event

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.vaha.server.notification.NotificationTypes
import com.vaha.server.util.ServerEnv

class ReaskedQuestionEvent(userId: String, content: String, username: String, topic: String) {

    init {
        val message = Message.builder()
            .putData("FCM_PAYLOAD_TYPE", NotificationTypes.FCM_TYPE_REASK)
            .putData("FCM_PAYLOAD_USER_ID", userId)
            .putData("FCM_PAYLOAD_USERNAME", username)
            .putData("FCM_PAYLOAD_CONTENT", content)
            .setTopic(topic)
            .build()

        FirebaseMessaging.getInstance().sendAsync(message, ServerEnv.isDev())
    }
}