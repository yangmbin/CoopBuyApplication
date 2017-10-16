package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author ymb
 * Create at 2017/10/16 10:36
 */
public class CategoryResponse implements Serializable {

    /**
     * categoryId : 24
     * name : 数码
     * imageUrl :
     * resume :
     * isRecommend : false
     * children : [{"categoryId":25,"name":" 摄影摄像 ","imageUrl":"","resume":"","isRecommend":false,"children":[{"categoryId":26,"name":" 数码相机","imageUrl":"https://oss.coopbuy.com/admin/images/41fd9f21-727c-4691-977c-f085d4fff05d.jpg","resume":"","isRecommend":false,"children":[]},{"categoryId":27,"name":"单反相机","imageUrl":"https://oss.coopbuy.com/admin/images/ffec5631-9815-4838-8400-762fb670b098.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":66,"name":"摄像机","imageUrl":"https://oss.coopbuy.com/admin/images/1f69aea9-b3dd-4dba-9729-b8f834d92dfd.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":72,"name":" 镜头","imageUrl":"https://oss.coopbuy.com/admin/images/ec938641-81eb-432c-851b-1179adabb46d.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":73,"name":" 数码相框","imageUrl":"https://oss.coopbuy.com/admin/images/778508c5-3be2-46ad-9ad1-76c96c16d2b4.jpg","resume":null,"isRecommend":false,"children":[]}]},{"categoryId":77,"name":" 影音娱乐 ","imageUrl":"","resume":null,"isRecommend":false,"children":[{"categoryId":78,"name":" 苹果配件","imageUrl":"https://oss.coopbuy.com/admin/images/829d377e-3106-4b41-a601-cff1a1d917e2.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":79,"name":" MP3MP4","imageUrl":"https://oss.coopbuy.com/admin/images/81765636-eb80-41c6-bf5e-619f70cebf09.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":80,"name":" 音箱音响","imageUrl":"https://oss.coopbuy.com/admin/images/6d13b21d-65ba-469d-9805-b93e53311416.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":81,"name":" 耳机耳麦","imageUrl":"https://oss.coopbuy.com/admin/images/bc906284-4d22-4d48-9a8e-30c6779cfcfb.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":82,"name":" 智能设备","imageUrl":"https://oss.coopbuy.com/admin/images/b35d077e-c038-40f1-9a29-84cab3e8694d.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":83,"name":" 麦克风","imageUrl":"https://oss.coopbuy.com/admin/images/7cf2f92a-c385-49f6-892e-a0cc11372929.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":84,"name":" 专业音频","imageUrl":"https://oss.coopbuy.com/admin/images/69ea01c2-2a4b-481b-aeb6-3b0a5fb0af03.jpg","resume":null,"isRecommend":false,"children":[]}]},{"categoryId":89,"name":" 数码配件 ","imageUrl":"","resume":null,"isRecommend":false,"children":[{"categoryId":90,"name":" 机身附件","imageUrl":"https://oss.coopbuy.com/admin/images/338eb1d9-9841-44a1-9370-75af23b17a04.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":91,"name":" 镜头附件","imageUrl":"https://oss.coopbuy.com/admin/images/60b2a7bc-7ea9-4302-bb15-85260e818795.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":92,"name":" 摄影配件","imageUrl":"https://oss.coopbuy.com/admin/images/dc217888-0966-45f7-b096-0741e82a7a9f.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":93,"name":" 滤镜","imageUrl":"https://oss.coopbuy.com/admin/images/e353a1d1-3089-4e75-bcdf-2c61124a83be.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":95,"name":" 闪光灯手柄","imageUrl":"https://oss.coopbuy.com/admin/images/4357a034-1616-44a1-baa8-7b3cd212cd7f.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":96,"name":" 存储卡","imageUrl":"https://oss.coopbuy.com/admin/images/7ce12ab6-0c05-4cfa-9e53-61db97e3391b.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":97,"name":" 读卡器","imageUrl":"https://oss.coopbuy.com/admin/images/c2b3dc02-0790-438b-88fa-7d8dfd4f8600.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":98,"name":" 三脚架云台","imageUrl":"https://oss.coopbuy.com/admin/images/17dd1108-8730-4f8c-81fc-f14192ae3f77.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":99,"name":" 相机清洁贴膜","imageUrl":"https://oss.coopbuy.com/admin/images/a3a73b28-227d-4d0f-a249-3189cdd91098.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":100,"name":" 电池充电器","imageUrl":"https://oss.coopbuy.com/admin/images/8ed9e8ad-dac6-40a6-ba9a-263659712049.jpg","resume":null,"isRecommend":false,"children":[]}]},{"categoryId":766,"name":"电子教育","imageUrl":"","resume":null,"isRecommend":false,"children":[{"categoryId":767,"name":"点读机","imageUrl":"","resume":null,"isRecommend":false,"children":[]}]},{"categoryId":768,"name":"早教益智","imageUrl":"","resume":null,"isRecommend":false,"children":[{"categoryId":769,"name":"儿童智能早教机","imageUrl":"","resume":null,"isRecommend":false,"children":[]}]}]
     */

    private int categoryId;
    private String name;
    private String imageUrl;
    private String resume;
    private boolean isRecommend;
    private List<ChildrenBeanX> children;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public boolean isIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX {
        /**
         * categoryId : 25
         * name :  摄影摄像
         * imageUrl :
         * resume :
         * isRecommend : false
         * children : [{"categoryId":26,"name":" 数码相机","imageUrl":"https://oss.coopbuy.com/admin/images/41fd9f21-727c-4691-977c-f085d4fff05d.jpg","resume":"","isRecommend":false,"children":[]},{"categoryId":27,"name":"单反相机","imageUrl":"https://oss.coopbuy.com/admin/images/ffec5631-9815-4838-8400-762fb670b098.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":66,"name":"摄像机","imageUrl":"https://oss.coopbuy.com/admin/images/1f69aea9-b3dd-4dba-9729-b8f834d92dfd.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":72,"name":" 镜头","imageUrl":"https://oss.coopbuy.com/admin/images/ec938641-81eb-432c-851b-1179adabb46d.jpg","resume":null,"isRecommend":false,"children":[]},{"categoryId":73,"name":" 数码相框","imageUrl":"https://oss.coopbuy.com/admin/images/778508c5-3be2-46ad-9ad1-76c96c16d2b4.jpg","resume":null,"isRecommend":false,"children":[]}]
         */

        private int categoryId;
        private String name;
        private String imageUrl;
        private String resume;
        private boolean isRecommend;
        private List<ChildrenBean> children;

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public boolean isIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(boolean isRecommend) {
            this.isRecommend = isRecommend;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * categoryId : 26
             * name :  数码相机
             * imageUrl : https://oss.coopbuy.com/admin/images/41fd9f21-727c-4691-977c-f085d4fff05d.jpg
             * resume :
             * isRecommend : false
             * children : []
             */

            private int categoryId;
            private String name;
            private String imageUrl;
            private String resume;
            private boolean isRecommend;
            private List<?> children;

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getResume() {
                return resume;
            }

            public void setResume(String resume) {
                this.resume = resume;
            }

            public boolean isIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(boolean isRecommend) {
                this.isRecommend = isRecommend;
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
