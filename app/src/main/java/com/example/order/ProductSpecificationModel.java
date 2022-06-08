package com.example.order;

public class ProductSpecificationModel {

    public static final int SPECIFICATION_TITLE =0;
    public static final int SPECIFICATION_BODY = 1;

    private int typ;

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }
    ///////////////////// specification title

    private String title;
    public ProductSpecificationModel(int typ, String title) {
        this.typ = typ;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ///////////////////// specification title


    ///////////////////////specification body
     private   String featureName;
     private String featureValue;

    public ProductSpecificationModel(int typ, String featureName, String featureValue) {
        this.typ = typ;
        this.featureName = featureName;
        this.featureValue = featureValue;
    }
    public String getFeatureName() {
        return featureName;
    }
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    public String getFeatureValue() {
        return featureValue;
    }
    public void setFeatureValue(String featureValue) {
        this.featureValue = featureValue;
    }
    ///////////////////////specification body

}
