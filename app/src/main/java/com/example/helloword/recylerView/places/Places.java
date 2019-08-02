package com.example.helloword.recylerView.places;

public class Places {
    String placeName;
    int isMoreDetail;
    int isPromotion ;

    public Places(String placeName, int isMoreDetail, int isPromotion) {
        this.placeName = placeName;
        this.isMoreDetail = isMoreDetail;
        this.isPromotion = isPromotion;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(int isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public int getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }
}
