package com.damjanvucina.jiraffe.ui;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

//https://jetbrains.org/intellij/sdk/docs/user_interface_components/notifications.html
public class UserNotification {
    private final NotificationGroup NOTIFICATION_GROUP = new NotificationGroup("Groovy DSL errors", NotificationDisplayType.BALLOON, true);

    public Notification notify(String content, NotificationType notificationType) {
        return notify(null, content, notificationType);
    }

    public Notification notify(Project project, String content, NotificationType notificationType) {
        final Notification notification = NOTIFICATION_GROUP.createNotification(content, NotificationType.ERROR);
        notification.notify(project);

        return notification;
    }
}
