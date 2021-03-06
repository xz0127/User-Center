package com.example.userCenter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_preference")
public class UserPreference implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false, length = 48)
    private String userId;

    @Column(name = "todo_notice", length = 1)
    private String todoNotice;

    @Column(name = "sys_message_notice", length = 1)
    private String sysMessageNotice;

    @Column(name = "other_user_message_notice", length = 1)
    private String otherUserMessageNotice;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTodoNotice() {
        return todoNotice;
    }

    public void setTodoNotice(String todoNotice) {
        this.todoNotice = todoNotice;
    }

    public String getSysMessageNotice() {
        return sysMessageNotice;
    }

    public void setSysMessageNotice(String sysMessageNotice) {
        this.sysMessageNotice = sysMessageNotice;
    }

    public String getOtherUserMessageNotice() {
        return otherUserMessageNotice;
    }

    public void setOtherUserMessageNotice(String otherUserMessageNotice) {
        this.otherUserMessageNotice = otherUserMessageNotice;
    }
}
