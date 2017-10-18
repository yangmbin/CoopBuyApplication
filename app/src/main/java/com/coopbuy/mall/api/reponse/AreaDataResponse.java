package com.coopbuy.mall.api.reponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class AreaDataResponse implements Serializable {


    /**
     * childs : [{"childs":[{}],"id":0,"name":"string"}]
     * id : 0
     * name : string
     */

    private long value;
    private String text;
    private List<ChildsBeanX> children;

    public long getId() {
        return value;
    }

    public void setId(long id) {
        this.value = id;
    }

    public String getName() {
        return text;
    }

    public void setName(String name) {
        this.text = name;
    }

    public List<ChildsBeanX> getChilds() {
        return children;
    }

    public void setChilds(List<ChildsBeanX> childs) {
        this.children = childs;
    }

    public class ChildsBeanX {

        private long value;
        private String text;
        private List<ChildsBeanY> children;

        public long getId() {
            return value;
        }

        public void setId(long id) {
            this.value = id;
        }

        public String getName() {
            return text;
        }

        public void setName(String name) {
            this.text = name;
        }

        public List<ChildsBeanY> getChilds() {
            return children;
        }

        public void setChilds(List<ChildsBeanY> childs) {
            this.children = childs;
        }

        public class ChildsBeanY {
            private long value;
            private String text;

            public long getId() {
                return value;
            }

            public void setId(long id) {
                this.value = id;
            }

            public String getName() {
                return text;
            }

            public void setName(String name) {
                this.text = name;
            }
        }
    }
}
