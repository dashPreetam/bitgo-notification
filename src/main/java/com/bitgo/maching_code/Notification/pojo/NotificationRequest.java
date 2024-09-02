/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
    private double currentPrice;
    private double dailyPercentage;
    private int tradingVolume;
    private String status;
}
