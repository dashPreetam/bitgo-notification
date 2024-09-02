/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.controller;

import com.bitgo.maching_code.Notification.constants.URLConstants;
import com.bitgo.maching_code.Notification.pojo.NotificationRequest;
import com.bitgo.maching_code.Notification.pojo.NotificationSendRequest;
import com.bitgo.maching_code.Notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = URLConstants.NOTIFICATION_BASE)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping()
    public ResponseEntity<Object> createNotification(@RequestBody NotificationRequest notificationRequest){
        try {
            int id = notificationService.newNotification(notificationRequest);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/send")
    public ResponseEntity<Object> sendNotification(@RequestBody NotificationSendRequest notificationSendRequest){
        try {
            notificationService.sendNotification(notificationSendRequest);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/send")
    public ResponseEntity<Object> sendNotification(@RequestParam(name = "status") String status){
        try {
            return new ResponseEntity<>(notificationService.getNotificationByStatus(status), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
