package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 10:14
 * @content 获取省市区数据
 */
public class GetProviencesReponse implements Serializable {

    /**
     * children : [{"children":[{"children":[],"value":110101000000,"text":"东城区"}],"value":0,"text":"string"}]
     * value : 0
     * text : string
     */

    private int value;
    private String text;
    private List<ChildrenBeanX> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX implements Serializable {
        /**
         * children : [{"children":[],"value":110101000000,"text":"东城区"}]
         * value : 0
         * text : string
         */

        private int value;
        private String text;
        private List<ChildrenBean> children;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
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
             * value : 110101000000
             * text : 东城区
             */

            private long value;
            private String text;
            private List<?> children;

            public long getValue() {
                return value;
            }

            public void setValue(long value) {
                this.value = value;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
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
