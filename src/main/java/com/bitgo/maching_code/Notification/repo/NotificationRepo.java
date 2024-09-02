package com.bitgo.maching_code.Notification.repo;

import com.bitgo.maching_code.Notification.model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<NotificationModel,Integer> {
}
