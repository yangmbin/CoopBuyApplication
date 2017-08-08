package com.coopbuy.mall.api.login;

import java.io.Serializable;
import java.util.List;

/**
 * @author csn
 * @date 2017/8/8 0008 14:05
 * @content
 */
public class RegionsResponse implements Serializable {

    /**
     * children : [{"children":[{"children":[],"value":110101000000,"text":"东城区"},{"children":[],"value":110102000000,"text":"西城区"},{"children":[],"value":110105000000,"text":"朝阳区"},{"children":[],"value":110106000000,"text":"丰台区"},{"children":[],"value":110107000000,"text":"石景山区"},{"children":[],"value":110108000000,"text":"海淀区"},{"children":[],"value":110109000000,"text":"门头沟区"},{"children":[],"value":110111000000,"text":"房山区"},{"children":[],"value":110112000000,"text":"通州区"},{"children":[],"value":110113000000,"text":"顺义区"},{"children":[],"value":110114000000,"text":"昌平区"},{"children":[],"value":110115000000,"text":"大兴区"},{"children":[],"value":110116000000,"text":"怀柔区"},{"children":[],"value":110117000000,"text":"平谷区"},{"children":[],"value":110118000000,"text":"密云区"},{"children":[],"value":110119000000,"text":"延庆区"}],"value":110100000000,"text":"市辖区"}]
     * value : 110000000000
     * text : 北京市
     */

    private long value;
    private String text;
    private List<ChildrenBeanX> children;

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

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX {
        /**
         * children : [{"children":[],"value":110101000000,"text":"东城区"},{"children":[],"value":110102000000,"text":"西城区"},{"children":[],"value":110105000000,"text":"朝阳区"},{"children":[],"value":110106000000,"text":"丰台区"},{"children":[],"value":110107000000,"text":"石景山区"},{"children":[],"value":110108000000,"text":"海淀区"},{"children":[],"value":110109000000,"text":"门头沟区"},{"children":[],"value":110111000000,"text":"房山区"},{"children":[],"value":110112000000,"text":"通州区"},{"children":[],"value":110113000000,"text":"顺义区"},{"children":[],"value":110114000000,"text":"昌平区"},{"children":[],"value":110115000000,"text":"大兴区"},{"children":[],"value":110116000000,"text":"怀柔区"},{"children":[],"value":110117000000,"text":"平谷区"},{"children":[],"value":110118000000,"text":"密云区"},{"children":[],"value":110119000000,"text":"延庆区"}]
         * value : 110100000000
         * text : 市辖区
         */

        private long value;
        private String text;
        private List<ChildrenBean> children;

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
