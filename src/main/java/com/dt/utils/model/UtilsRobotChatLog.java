package com.dt.utils.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "utils_robot_chat_log")
public class UtilsRobotChatLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "send_messang")
    private String sendMessang;

    @Column(name = "receive_message")
    private String receiveMessage;

    @Column(name = "channel_name")
    private String channelName;

    @Column(name = "send_time")
    private Date sendTime;

    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return send_messang
     */
    public String getSendMessang() {
        return sendMessang;
    }

    /**
     * @param sendMessang
     */
    public void setSendMessang(String sendMessang) {
        this.sendMessang = sendMessang;
    }

    /**
     * @return receive_message
     */
    public String getReceiveMessage() {
        return receiveMessage;
    }

    /**
     * @param receiveMessage
     */
    public void setReceiveMessage(String receiveMessage) {
        this.receiveMessage = receiveMessage;
    }

    /**
     * @return channel_name
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * @param channelName
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * @return send_time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return receive_time
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * @param receiveTime
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}