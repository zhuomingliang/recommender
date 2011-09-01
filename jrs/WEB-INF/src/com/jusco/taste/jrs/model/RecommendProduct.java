package com.jusco.taste.jrs.model;

public class RecommendProduct {
    private Product product;
    private float value;

    public RecommendProduct(Product product, float value){
        this.product = product;
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Movie:\t" + product.toString() + "\t");
        sb.append("Score:\t" + value);
        return sb.toString();
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("{'movie':" + product.toJSON() + ",");
        sb.append("'score':" + value + "}");
        return sb.toString();
    }
}
