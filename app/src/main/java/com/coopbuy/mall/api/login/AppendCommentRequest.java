package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 11:02
 * @content
 */
public class AppendCommentRequest implements Serializable{

    /**
     * parentId : 0
     * productId : 0
     * commenContent : string
     * commentImages : ["string"]
     */

    private int parentId;
    private int productId;
    private String commenContent;
    private List<String> commentImages;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCommenContent() {
        return commenContent;
    }

    public void setCommenContent(String commenContent) {
        this.commenContent = commenContent;
    }

    public List<String> getCommentImages() {
        return commentImages;
    }

    public void setCommentImages(List<String> commentImages) {
        this.commentImages = commentImages;
    }
}
