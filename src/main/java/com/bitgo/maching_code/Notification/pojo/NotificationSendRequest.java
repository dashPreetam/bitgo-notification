/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationSendRequest {

    private int notificationId;
    private List<String> email;

}
