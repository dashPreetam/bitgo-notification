package com.bitgo.maching_code.Notification.repo;

import com.bitgo.maching_code.Notification.model.NotificationSendDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationSendDetailsRepo extends JpaRepository<NotificationSendDetailsModel, Integer> {
    List<NotificationSendDetailsModel> findAllByStatus(String status);
}
