package com.young.vo;

import com.young.entity.User;
import com.young.entity.UserAndTask;

public class TaskQueryVo {
    private UserAndTask userAndTask;
    private User user;

    public UserAndTask getUserAndTask() {
        return userAndTask;
    }

    public void setUserAndTask(UserAndTask userAndTask) {
        this.userAndTask = userAndTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
