package com.coopbuy.mall.api.login;

import java.io.Serializable;

/**
 * @author csn
 * @date 2017/8/9 0009 11:33
 * @content 修改那个出那个值
 */
public class MobifyMemberRequest implements Serializable {

    /**
     * nick : string
     * sex : 0
     * email : string
     * idCard : string
     * idPhotoPath : string
     * birthday : 2017-08-09T01:41:09.233Z
     */

    private String nick;
    private int sex;
    private String email;
    private String idCard;
    private String idPhotoPath;
    private String birthday;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdPhotoPath() {
        return idPhotoPath;
    }

    public void setIdPhotoPath(String idPhotoPath) {
        this.idPhotoPath = idPhotoPath;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
