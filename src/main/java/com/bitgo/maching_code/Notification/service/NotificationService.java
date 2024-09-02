/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.service;

import com.bitgo.maching_code.Notification.model.NotificationModel;
import com.bitgo.maching_code.Notification.model.NotificationSendDetailsModel;
import com.bitgo.maching_code.Notification.pojo.NotificationRequest;
import com.bitgo.maching_code.Notification.pojo.NotificationSendRequest;
import com.bitgo.maching_code.Notification.repo.NotificationRepo;
import com.bitgo.maching_code.Notification.repo.NotificationSendDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private NotificationSendDetailsRepo sendDetailsRepo;

    public int newNotification(NotificationRequest notificationRequest) {
        NotificationModel notification = new NotificationModel();
        notification.setCurrentPrice(notificationRequest.getCurrentPrice());
        notification.setDailyPercentage(notificationRequest.getDailyPercentage());
        notification.setTradingVolume(notification.getTradingVolume());
        notification.setStatus(notificationRequest.getStatus());
        notification.setId((int) (notificationRepo.count() +1));

        notificationRepo.save(notification);
        return notification.getId();
    }

    public void sendNotification(NotificationSendRequest notificationSendRequest) {

        notificationSendRequest.getEmail().forEach(email -> {
            NotificationSendDetailsModel model = new NotificationSendDetailsModel();
            model.setNotificationId(notificationSendRequest.getNotificationId());
            model.setEmail(email);
            model.setStatus("SENDING");
            model.setId((int) (sendDetailsRepo.count() + 1));

            sendDetailsRepo.save(model);
        });

    }

    public List<NotificationSendDetailsModel> getNotificationByStatus(String status) {
        return sendDetailsRepo.findAllByStatus(status);
    }

    public NotificationModel updateNotification(int id, NotificationRequest notificationRequest) {
        NotificationModel notification = new NotificationModel();
        notification.setCurrentPrice(notificationRequest.getCurrentPrice());
        notification.setDailyPercentage(notificationRequest.getDailyPercentage());
        notification.setTradingVolume(notification.getTradingVolume());
        notification.setStatus(notificationRequest.getStatus());
        notification.setId(id);

        return notificationRepo.save(notification);
    }
}
