package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/14 0014 10:51
 * @content
 */
public class GetGoodsParentCategorysResponse  implements Serializable{

    /**
     * children : [{"children":[{}],"id":0,"sortId":0,"categoryName":"string","fullId":"string","fullName":"string","level":0,"parentId":0,"minCommissionRete":0,"templateId":0,"enableState":0,"imageUrl":"string"}]
     * id : 0
     * sortId : 0
     * categoryName : string
     * fullId : string
     * fullName : string
     * level : 0
     * parentId : 0
     * minCommissionRete : 0
     * templateId : 0
     * enableState : 0
     * imageUrl : string
     */

    private int id;
    private int sortId;
    private String categoryName;
    private String fullId;
    private String fullName;
    private int level;
    private int parentId;
    private int minCommissionRete;
    private int templateId;
    private int enableState;
    private String imageUrl;
    private List<ChildrenBeanX> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getMinCommissionRete() {
        return minCommissionRete;
    }

    public void setMinCommissionRete(int minCommissionRete) {
        this.minCommissionRete = minCommissionRete;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getEnableState() {
        return enableState;
    }

    public void setEnableState(int enableState) {
        this.enableState = enableState;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX {
        /**
         * children : [{}]
         * id : 0
         * sortId : 0
         * categoryName : string
         * fullId : string
         * fullName : string
         * level : 0
         * parentId : 0
         * minCommissionRete : 0
         * templateId : 0
         * enableState : 0
         * imageUrl : string
         */

        private int id;
        private int sortId;
        private String categoryName;
        private String fullId;
        private String fullName;
        private int level;
        private int parentId;
        private int minCommissionRete;
        private int templateId;
        private int enableState;
        private String imageUrl;
        private List<ChildrenBean> children;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSortId() {
            return sortId;
        }

        public void setSortId(int sortId) {
            this.sortId = sortId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getFullId() {
            return fullId;
        }

        public void setFullId(String fullId) {
            this.fullId = fullId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getMinCommissionRete() {
            return minCommissionRete;
        }

        public void setMinCommissionRete(int minCommissionRete) {
            this.minCommissionRete = minCommissionRete;
        }

        public int getTemplateId() {
            return templateId;
        }

        public void setTemplateId(int templateId) {
            this.templateId = templateId;
        }

        public int getEnableState() {
            return enableState;
        }

        public void setEnableState(int enableState) {
            this.enableState = enableState;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
        }
    }
}
