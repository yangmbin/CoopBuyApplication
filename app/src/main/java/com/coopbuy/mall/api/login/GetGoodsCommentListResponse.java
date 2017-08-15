package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 11:01
 * @content
 */
public class  GetGoodsCommentListResponse implements Serializable {

    /**
     * rowCount : 0
     * pageCount : 0
     * currentPage : 0
     * pageSize : 0
     * items : [{"childs":[{"images":[{"goodsCommentId":0,"remark":"string","imageUrl":"string"}],"commentChilds":[{}],"id":0,"orderId":"string","productId":0,"commenContent":"string","goodsGrade":0,"parentId":0,"commenType":0,"productImage":"string","creatorUserName":"string","creationTime":"string","avatar":"string","goodsSpecification":"string","productName":"string","isReplay":true}],"images":[{"goodsCommentId":0,"remark":"string","imageUrl":"string"}],"commentChilds":[{"images":[{"goodsCommentId":0,"remark":"string","imageUrl":"string"}],"commentChilds":[{}],"id":0,"orderId":"string","productId":0,"commenContent":"string","goodsGrade":0,"parentId":0,"commenType":0,"productImage":"string","creatorUserName":"string","creationTime":"string","avatar":"string","goodsSpecification":"string","productName":"string","isReplay":true}],"id":0,"orderId":"string","productId":0,"commenContent":"string","goodsGrade":0,"parentId":0,"commenType":0,"productImage":"string","creatorUserName":"string","creationTime":"string","avatar":"string","goodsSpecification":"string","productName":"string","isReplay":true}]
     */

    private int rowCount;
    private int pageCount;
    private int currentPage;
    private int pageSize;
    private List<ItemsBean> items;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * childs : [{"images":[{"goodsCommentId":0,"remark":"string","imageUrl":"string"}],"commentChilds":[{}],"id":0,"orderId":"string","productId":0,"commenContent":"string","goodsGrade":0,"parentId":0,"commenType":0,"productImage":"string","creatorUserName":"string","creationTime":"string","avatar":"string","goodsSpecification":"string","productName":"string","isReplay":true}]
         * images : [{"goodsCommentId":0,"remark":"string","imageUrl":"string"}]
         * commentChilds : [{"images":[{"goodsCommentId":0,"remark":"string","imageUrl":"string"}],"commentChilds":[{}],"id":0,"orderId":"string","productId":0,"commenContent":"string","goodsGrade":0,"parentId":0,"commenType":0,"productImage":"string","creatorUserName":"string","creationTime":"string","avatar":"string","goodsSpecification":"string","productName":"string","isReplay":true}]
         * id : 0
         * orderId : string
         * productId : 0
         * commenContent : string
         * goodsGrade : 0
         * parentId : 0
         * commenType : 0
         * productImage : string
         * creatorUserName : string
         * creationTime : string
         * avatar : string
         * goodsSpecification : string
         * productName : string
         * isReplay : true
         */

        private int id;
        private String orderId;
        private int productId;
        private String commenContent;
        private int goodsGrade;
        private int parentId;
        private int commenType;
        private String productImage;
        private String creatorUserName;
        private String creationTime;
        private String avatar;
        private String goodsSpecification;
        private String productName;
        private boolean isReplay;
        private List<ChildsBean> childs;
        private List<ImagesBeanX> images;
        private List<CommentChildsBeanXX> commentChilds;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
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

        public int getGoodsGrade() {
            return goodsGrade;
        }

        public void setGoodsGrade(int goodsGrade) {
            this.goodsGrade = goodsGrade;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getCommenType() {
            return commenType;
        }

        public void setCommenType(int commenType) {
            this.commenType = commenType;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public String getCreatorUserName() {
            return creatorUserName;
        }

        public void setCreatorUserName(String creatorUserName) {
            this.creatorUserName = creatorUserName;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getGoodsSpecification() {
            return goodsSpecification;
        }

        public void setGoodsSpecification(String goodsSpecification) {
            this.goodsSpecification = goodsSpecification;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public boolean isIsReplay() {
            return isReplay;
        }

        public void setIsReplay(boolean isReplay) {
            this.isReplay = isReplay;
        }

        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
        }

        public List<ImagesBeanX> getImages() {
            return images;
        }

        public void setImages(List<ImagesBeanX> images) {
            this.images = images;
        }

        public List<CommentChildsBeanXX> getCommentChilds() {
            return commentChilds;
        }

        public void setCommentChilds(List<CommentChildsBeanXX> commentChilds) {
            this.commentChilds = commentChilds;
        }

        public static class ChildsBean {
            /**
             * images : [{"goodsCommentId":0,"remark":"string","imageUrl":"string"}]
             * commentChilds : [{}]
             * id : 0
             * orderId : string
             * productId : 0
             * commenContent : string
             * goodsGrade : 0
             * parentId : 0
             * commenType : 0
             * productImage : string
             * creatorUserName : string
             * creationTime : string
             * avatar : string
             * goodsSpecification : string
             * productName : string
             * isReplay : true
             */

            private int id;
            private String orderId;
            private int productId;
            private String commenContent;
            private int goodsGrade;
            private int parentId;
            private int commenType;
            private String productImage;
            private String creatorUserName;
            private String creationTime;
            private String avatar;
            private String goodsSpecification;
            private String productName;
            private boolean isReplay;
            private List<ImagesBean> images;
            private List<CommentChildsBean> commentChilds;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
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

            public int getGoodsGrade() {
                return goodsGrade;
            }

            public void setGoodsGrade(int goodsGrade) {
                this.goodsGrade = goodsGrade;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getCommenType() {
                return commenType;
            }

            public void setCommenType(int commenType) {
                this.commenType = commenType;
            }

            public String getProductImage() {
                return productImage;
            }

            public void setProductImage(String productImage) {
                this.productImage = productImage;
            }

            public String getCreatorUserName() {
                return creatorUserName;
            }

            public void setCreatorUserName(String creatorUserName) {
                this.creatorUserName = creatorUserName;
            }

            public String getCreationTime() {
                return creationTime;
            }

            public void setCreationTime(String creationTime) {
                this.creationTime = creationTime;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getGoodsSpecification() {
                return goodsSpecification;
            }

            public void setGoodsSpecification(String goodsSpecification) {
                this.goodsSpecification = goodsSpecification;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public boolean isIsReplay() {
                return isReplay;
            }

            public void setIsReplay(boolean isReplay) {
                this.isReplay = isReplay;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public List<CommentChildsBean> getCommentChilds() {
                return commentChilds;
            }

            public void setCommentChilds(List<CommentChildsBean> commentChilds) {
                this.commentChilds = commentChilds;
            }

            public static class ImagesBean {
            }

            public static class CommentChildsBean {
            }
        }

        public static class ImagesBeanX {
            /**
             * goodsCommentId : 0
             * remark : string
             * imageUrl : string
             */

            private int goodsCommentId;
            private String remark;
            private String imageUrl;

            public int getGoodsCommentId() {
                return goodsCommentId;
            }

            public void setGoodsCommentId(int goodsCommentId) {
                this.goodsCommentId = goodsCommentId;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public static class CommentChildsBeanXX {
            /**
             * images : [{"goodsCommentId":0,"remark":"string","imageUrl":"string"}]
             * commentChilds : [{}]
             * id : 0
             * orderId : string
             * productId : 0
             * commenContent : string
             * goodsGrade : 0
             * parentId : 0
             * commenType : 0
             * productImage : string
             * creatorUserName : string
             * creationTime : string
             * avatar : string
             * goodsSpecification : string
             * productName : string
             * isReplay : true
             */

            private int id;
            private String orderId;
            private int productId;
            private String commenContent;
            private int goodsGrade;
            private int parentId;
            private int commenType;
            private String productImage;
            private String creatorUserName;
            private String creationTime;
            private String avatar;
            private String goodsSpecification;
            private String productName;
            private boolean isReplay;
            private List<ImagesBeanXX> images;
            private List<CommentChildsBeanX> commentChilds;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
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

            public int getGoodsGrade() {
                return goodsGrade;
            }

            public void setGoodsGrade(int goodsGrade) {
                this.goodsGrade = goodsGrade;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getCommenType() {
                return commenType;
            }

            public void setCommenType(int commenType) {
                this.commenType = commenType;
            }

            public String getProductImage() {
                return productImage;
            }

            public void setProductImage(String productImage) {
                this.productImage = productImage;
            }

            public String getCreatorUserName() {
                return creatorUserName;
            }

            public void setCreatorUserName(String creatorUserName) {
                this.creatorUserName = creatorUserName;
            }

            public String getCreationTime() {
                return creationTime;
            }

            public void setCreationTime(String creationTime) {
                this.creationTime = creationTime;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getGoodsSpecification() {
                return goodsSpecification;
            }

            public void setGoodsSpecification(String goodsSpecification) {
                this.goodsSpecification = goodsSpecification;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public boolean isIsReplay() {
                return isReplay;
            }

            public void setIsReplay(boolean isReplay) {
                this.isReplay = isReplay;
            }

            public List<ImagesBeanXX> getImages() {
                return images;
            }

            public void setImages(List<ImagesBeanXX> images) {
                this.images = images;
            }

            public List<CommentChildsBeanX> getCommentChilds() {
                return commentChilds;
            }

            public void setCommentChilds(List<CommentChildsBeanX> commentChilds) {
                this.commentChilds = commentChilds;
            }

            public static class ImagesBeanXX {
            }

            public static class CommentChildsBeanX {
            }
        }
    }
}
