package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 10:58
 * @content
 */
public class AddGoodsCommentRequest implements Serializable {

    /**
     * goodsCommentInputs : [{"parentId":0,"productId":0,"commenContent":"string","skuId":0,"score":0,"goodsGrade":0,"commentImages":["string"]}]
     * orderId : string
     * serviceAttitude : 0
     * logisticsService : 0
     */

    private String orderId;
    private int serviceAttitude;
    private int logisticsService;
    private List<GoodsCommentInputsBean> goodsCommentInputs;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getServiceAttitude() {
        return serviceAttitude;
    }

    public void setServiceAttitude(int serviceAttitude) {
        this.serviceAttitude = serviceAttitude;
    }

    public int getLogisticsService() {
        return logisticsService;
    }

    public void setLogisticsService(int logisticsService) {
        this.logisticsService = logisticsService;
    }

    public List<GoodsCommentInputsBean> getGoodsCommentInputs() {
        return goodsCommentInputs;
    }

    public void setGoodsCommentInputs(List<GoodsCommentInputsBean> goodsCommentInputs) {
        this.goodsCommentInputs = goodsCommentInputs;
    }

    public static class GoodsCommentInputsBean {
        /**
         * parentId : 0
         * productId : 0
         * commenContent : string
         * skuId : 0
         * score : 0
         * goodsGrade : 0
         * commentImages : ["string"]
         */

        private int parentId;
        private int productId;
        private String commenContent;
        private int skuId;
        private int score;
        private int goodsGrade;
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

        public int getSkuId() {
            return skuId;
        }

        public void setSkuId(int skuId) {
            this.skuId = skuId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getGoodsGrade() {
            return goodsGrade;
        }

        public void setGoodsGrade(int goodsGrade) {
            this.goodsGrade = goodsGrade;
        }

        public List<String> getCommentImages() {
            return commentImages;
        }

        public void setCommentImages(List<String> commentImages) {
            this.commentImages = commentImages;
        }
    }
}
