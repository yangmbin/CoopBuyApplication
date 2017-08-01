package com.coopbuy.mall.api.classify;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/1 0001 15:11
 * @content
 */
public class CategorysResponse implements Serializable {

    /**
     * children : [{"children":[{"children":[],"id":52,"sortId":0,"categoryName":" 饭盒提锅","fullId":"28/30/52","fullName":"厨具 / 厨房配件 / 饭盒提锅","level":3,"parentId":30,"minCommissionRete":6,"templateId":47,"enableState":1,"imageUrl":"/admin/images/b76162fb-0bfd-416d-82cc-7ae5a9ba09a4.jpg"},{"children":[],"id":160,"sortId":0,"categoryName":" 储物置物架","fullId":"28/30/160","fullName":"厨具 / 厨房配件 / 储物置物架","level":3,"parentId":30,"minCommissionRete":6,"templateId":182,"enableState":1,"imageUrl":"/admin/images/d4c5aea2-8a07-4a1a-bb7b-456c252fd83a.jpg"},{"children":[],"id":161,"sortId":0,"categoryName":" 厨房DIY小工具","fullId":"28/30/161","fullName":"厨具 / 厨房配件 / 厨房DIY小工具","level":3,"parentId":30,"minCommissionRete":1,"templateId":184,"enableState":1,"imageUrl":"/admin/images/e80f673f-41ab-4624-9a0c-6ec0520a3ce1.jpg"}],"id":30,"sortId":0,"categoryName":" 厨房配件 ","fullId":"28/30","fullName":"厨具 / 厨房配件 ","level":2,"parentId":28,"minCommissionRete":null,"templateId":null,"enableState":1,"imageUrl":null},{"children":[{"children":[],"id":71,"sortId":0,"categoryName":"保温杯","fullId":"28/56/71","fullName":"厨具 / 水具酒具 /保温杯","level":3,"parentId":56,"minCommissionRete":6,"templateId":118,"enableState":1,"imageUrl":"/admin/images/79203165-4671-4fc2-b132-8ff9a5942cf5.jpg"},{"children":[],"id":94,"sortId":0,"categoryName":"保温壶","fullId":"28/56/94","fullName":"厨具 / 水具酒具 /保温壶","level":3,"parentId":56,"minCommissionRete":6,"templateId":128,"enableState":1,"imageUrl":"/admin/images/d2cb76b5-b7c8-4072-9b8a-51733f8d67e4.jpg"}],"id":56,"sortId":0,"categoryName":" 水具酒具 ","fullId":"28/56","fullName":"厨具 / 水具酒具 ","level":2,"parentId":28,"minCommissionRete":null,"templateId":null,"enableState":1,"imageUrl":null},{"children":[{"children":[],"id":164,"sortId":0,"categoryName":" 筷勺刀叉","fullId":"28/128/164","fullName":"厨具 /餐具/ 筷勺刀叉","level":3,"parentId":128,"minCommissionRete":1,"templateId":193,"enableState":1,"imageUrl":"/admin/images/5a4d4271-abb1-4e6e-a354-d6bf4e62ba3d.jpg"}],"id":128,"sortId":0,"categoryName":"餐具","fullId":"28/128","fullName":"厨具 /餐具","level":2,"parentId":28,"minCommissionRete":null,"templateId":null,"enableState":1,"imageUrl":null},{"children":[{"children":[],"id":142,"sortId":0,"categoryName":" 火锅","fullId":"28/141/142","fullName":"厨具 / 烹饪锅具 / 火锅","level":3,"parentId":141,"minCommissionRete":6,"templateId":84,"enableState":1,"imageUrl":"/admin/images/ff0e97f5-9a07-42fe-b73a-22833e19eaac.jpg"},{"children":[],"id":143,"sortId":0,"categoryName":" 炒锅","fullId":"28/141/143","fullName":"厨具 / 烹饪锅具 / 炒锅","level":3,"parentId":141,"minCommissionRete":6,"templateId":136,"enableState":1,"imageUrl":"/admin/images/cca09299-8c1c-4b15-b6d5-a1a49a31d9fb.jpg"},{"children":[],"id":144,"sortId":0,"categoryName":" 煎锅","fullId":"28/141/144","fullName":"厨具 / 烹饪锅具 / 煎锅","level":3,"parentId":141,"minCommissionRete":6,"templateId":142,"enableState":1,"imageUrl":"/admin/images/a5c22562-7a72-4da4-bc9c-1758b7092a46.jpg"},{"children":[],"id":146,"sortId":0,"categoryName":" 蒸锅","fullId":"28/141/146","fullName":"厨具 / 烹饪锅具 / 蒸锅","level":3,"parentId":141,"minCommissionRete":1,"templateId":156,"enableState":1,"imageUrl":"/admin/images/2487fc6e-fc99-4491-af4d-6c1d7583ba1a.jpg"},{"children":[],"id":147,"sortId":0,"categoryName":" 汤锅","fullId":"28/141/147","fullName":"厨具 / 烹饪锅具 / 汤锅","level":3,"parentId":141,"minCommissionRete":6,"templateId":158,"enableState":1,"imageUrl":"/admin/images/38f290cf-d197-4f8b-8d5b-52f75b13021e.jpg"},{"children":[],"id":148,"sortId":0,"categoryName":" 奶锅","fullId":"28/141/148","fullName":"厨具 / 烹饪锅具 / 奶锅","level":3,"parentId":141,"minCommissionRete":6,"templateId":161,"enableState":1,"imageUrl":"/admin/images/81771a8d-8d80-44a1-af46-09631d16d4be.jpg"},{"children":[],"id":149,"sortId":0,"categoryName":" 锅具套装","fullId":"28/141/149","fullName":"厨具 / 烹饪锅具 / 锅具套装","level":3,"parentId":141,"minCommissionRete":6,"templateId":166,"enableState":1,"imageUrl":"/admin/images/10ae858e-91f2-4aa0-97e8-3bcb19d10ed4.jpg"},{"children":[],"id":151,"sortId":0,"categoryName":" 水壶","fullId":"28/141/151","fullName":"厨具 / 烹饪锅具 / 水壶","level":3,"parentId":141,"minCommissionRete":6,"templateId":170,"enableState":1,"imageUrl":"/admin/images/d3cf4619-cd25-442a-bb52-ccf51131f526.jpg"}],"id":141,"sortId":0,"categoryName":" 烹饪锅具 ","fullId":"28/141","fullName":"厨具 / 烹饪锅具 ","level":2,"parentId":28,"minCommissionRete":null,"templateId":null,"enableState":1,"imageUrl":null},{"children":[{"children":[],"id":154,"sortId":0,"categoryName":" 瓜果刀/刨","fullId":"28/152/154","fullName":"厨具 / 刀剪菜板 / 瓜果刀/刨","level":3,"parentId":152,"minCommissionRete":6,"templateId":174,"enableState":1,"imageUrl":"/admin/images/12367324-5508-4e35-988d-9b4bc83357cc.jpg"},{"children":[],"id":156,"sortId":0,"categoryName":" 菜刀","fullId":"28/152/156","fullName":"厨具 / 刀剪菜板 / 菜刀","level":3,"parentId":152,"minCommissionRete":6,"templateId":176,"enableState":1,"imageUrl":"/admin/images/3ddf8666-fb2b-45c4-a128-843be8d92597.jpg"},{"children":[],"id":157,"sortId":0,"categoryName":" 剪刀","fullId":"28/152/157","fullName":"厨具 / 刀剪菜板 / 剪刀","level":3,"parentId":152,"minCommissionRete":6,"templateId":177,"enableState":1,"imageUrl":"/admin/images/6c529d85-a4e6-46fa-aaca-a32a35980681.jpg"},{"children":[],"id":158,"sortId":0,"categoryName":" 刀具套装","fullId":"28/152/158","fullName":"厨具 / 刀剪菜板 / 刀具套装","level":3,"parentId":152,"minCommissionRete":6,"templateId":180,"enableState":1,"imageUrl":"/admin/images/ba34c096-1eff-45b2-9756-ac74f4fe76e6.jpg"},{"children":[],"id":159,"sortId":0,"categoryName":" 砧板","fullId":"28/152/159","fullName":"厨具 / 刀剪菜板 / 砧板","level":3,"parentId":152,"minCommissionRete":6,"templateId":181,"enableState":1,"imageUrl":"/admin/images/34b3a3b3-e15a-47dc-88f7-29b736ec89bc.jpg"}],"id":152,"sortId":0,"categoryName":" 刀剪菜板 ","fullId":"28/152","fullName":"厨具 / 刀剪菜板 ","level":2,"parentId":28,"minCommissionRete":null,"templateId":null,"enableState":1,"imageUrl":null}]
     * id : 28
     * sortId : 0
     * categoryName : 厨具
     * fullId : 28
     * fullName : 厨具
     * level : 1
     * parentId : null
     * minCommissionRete : null
     * templateId : null
     * enableState : 1
     * imageUrl : null
     */

    private int id;
    private int sortId;
    private String categoryName;
    private String fullId;
    private String fullName;
    private int level;
    private Object parentId;
    private Object minCommissionRete;
    private Object templateId;
    private int enableState;
    private Object imageUrl;
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

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Object getMinCommissionRete() {
        return minCommissionRete;
    }

    public void setMinCommissionRete(Object minCommissionRete) {
        this.minCommissionRete = minCommissionRete;
    }

    public Object getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Object templateId) {
        this.templateId = templateId;
    }

    public int getEnableState() {
        return enableState;
    }

    public void setEnableState(int enableState) {
        this.enableState = enableState;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
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
         * children : [{"children":[],"id":52,"sortId":0,"categoryName":" 饭盒提锅","fullId":"28/30/52","fullName":"厨具 / 厨房配件 / 饭盒提锅","level":3,"parentId":30,"minCommissionRete":6,"templateId":47,"enableState":1,"imageUrl":"/admin/images/b76162fb-0bfd-416d-82cc-7ae5a9ba09a4.jpg"},{"children":[],"id":160,"sortId":0,"categoryName":" 储物置物架","fullId":"28/30/160","fullName":"厨具 / 厨房配件 / 储物置物架","level":3,"parentId":30,"minCommissionRete":6,"templateId":182,"enableState":1,"imageUrl":"/admin/images/d4c5aea2-8a07-4a1a-bb7b-456c252fd83a.jpg"},{"children":[],"id":161,"sortId":0,"categoryName":" 厨房DIY小工具","fullId":"28/30/161","fullName":"厨具 / 厨房配件 / 厨房DIY小工具","level":3,"parentId":30,"minCommissionRete":1,"templateId":184,"enableState":1,"imageUrl":"/admin/images/e80f673f-41ab-4624-9a0c-6ec0520a3ce1.jpg"}]
         * id : 30
         * sortId : 0
         * categoryName :  厨房配件
         * fullId : 28/30
         * fullName : 厨具 / 厨房配件
         * level : 2
         * parentId : 28
         * minCommissionRete : null
         * templateId : null
         * enableState : 1
         * imageUrl : null
         */

        private int id;
        private int sortId;
        private String categoryName;
        private String fullId;
        private String fullName;
        private int level;
        private int parentId;
        private Object minCommissionRete;
        private Object templateId;
        private int enableState;
        private Object imageUrl;
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

        public Object getMinCommissionRete() {
            return minCommissionRete;
        }

        public void setMinCommissionRete(Object minCommissionRete) {
            this.minCommissionRete = minCommissionRete;
        }

        public Object getTemplateId() {
            return templateId;
        }

        public void setTemplateId(Object templateId) {
            this.templateId = templateId;
        }

        public int getEnableState() {
            return enableState;
        }

        public void setEnableState(int enableState) {
            this.enableState = enableState;
        }

        public Object getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(Object imageUrl) {
            this.imageUrl = imageUrl;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * children : []
             * id : 52
             * sortId : 0
             * categoryName :  饭盒提锅
             * fullId : 28/30/52
             * fullName : 厨具 / 厨房配件 / 饭盒提锅
             * level : 3
             * parentId : 30
             * minCommissionRete : 6
             * templateId : 47
             * enableState : 1
             * imageUrl : /admin/images/b76162fb-0bfd-416d-82cc-7ae5a9ba09a4.jpg
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
            private List<?> children;

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

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }
    }
}
