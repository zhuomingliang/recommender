package com.jusco.taste.jrs.model;

import java.util.HashMap;
import java.util.Map;

public class ProductList {

    private Map<Product, Float> products = new HashMap<Product, Float>();

    public void add(Product p, Float f){
        products.put(p, f);
    }

    public Float get(Product p){
        return products.get(p);
    }

    public Float remove(Product p){
        return products.remove(p);
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean flag = false;
        for(Map.Entry<Product, Float> item: products.entrySet()){

            if(flag){
                sb.append(", ");
            } else {
                flag = true;
            }
            sb.append("{'product':" + item.getKey().toJSON() + ", ");
            sb.append("'score':" + item.getValue() + "}");

        }
        sb.append("]");
        return sb.toString();
    }
}
