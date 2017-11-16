package com.coopbuy.mall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangmbin
 * Create at 2017/11/16 9:42
 */
public class CategoryIntentData implements Serializable{

    private int currentIndex;
    private List<Item> itemList;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static class Item implements Serializable {
        private String categoryName;
        private int categoryId;
        private String friendlyName;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getFriendlyName() {
            return friendlyName;
        }

        public void setFriendlyName(String friendlyName) {
            this.friendlyName = friendlyName;
        }
    }

    public String[] getFriendlyNameList() {
        String[] nameList = new String[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
            nameList[i] = itemList.get(i).getFriendlyName();
        }
        nameList[0] = "全部";
        return nameList;
    }
}
