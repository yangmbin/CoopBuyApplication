package com.coopbuy.mall.api.reponse;

import java.io.Serializable;

/**
 * @author yangmbin
 * Create at 2017/11/23 9:14
 */
public class CheckUpdateResponse implements Serializable {

    /**
     * version : string
     * description : string
     * downLoadUrl : string
     * fileSize : 0
     * hasNewVersion : true
     */

    private String version;
    private String description;
    private String downLoadUrl;
    private int fileSize;
    private boolean hasNewVersion;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isHasNewVersion() {
        return hasNewVersion;
    }

    public void setHasNewVersion(boolean hasNewVersion) {
        this.hasNewVersion = hasNewVersion;
    }
}
