/*

 * Date : 02/09/24

 * Author : SWASTIK PREETAM DASH

 */

package com.bitgo.maching_code.Notification.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notification_send_details")
public class NotificationSendDetailsModel {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "notification_id")
    private int notificationId;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;
}
