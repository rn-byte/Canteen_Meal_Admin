package com.inim.canteenmealadmin;

public class NewMenuDataHolder {



    String foodName,foodId;
    int foodPrice;

    NewMenuDataHolder(){}
    NewMenuDataHolder(String foodId,String foodName,int foodPrice){
        this.foodId=foodId;
        this.foodName=foodName;
        this.foodPrice=foodPrice;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }


    public String getFoodName() {
        return foodName;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodPrice() {
        return foodPrice;
    }
}
