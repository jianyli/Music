package com.li.dto;

import com.li.entity.Mood;

import java.io.Serializable;

public class MoodDto extends Mood implements Serializable {
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "MoodDto{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
