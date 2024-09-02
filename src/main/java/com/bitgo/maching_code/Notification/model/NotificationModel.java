/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notification")
public class NotificationModel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "daily_percentage")
    private double dailyPercentage;

    @Column(name = "trading_volume")
    private int tradingVolume;

    @Column(name = "status")
    private String status;
}
