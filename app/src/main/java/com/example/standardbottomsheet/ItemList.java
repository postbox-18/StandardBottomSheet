package com.example.standardbottomsheet;

public class ItemList {
    private String itemName,itemCount;
    public ItemList(){

    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCount() {
        return itemCount;
    }
}
