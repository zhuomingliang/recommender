package com.jusco.taste.jrs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import com.jusco.taste.jrs.model.table.ProductTable;

public class RecommendProductList {
    private List<RecommendProduct> recommendProducts = new ArrayList<RecommendProduct>();
    public RecommendProductList(){

    }
    public RecommendProductList(List<RecommendedItem> items){
        List<String> productIDList = new ArrayList<String>();
        for (RecommendedItem item : items){
            productIDList.add(String.valueOf(item.getItemID()));
        }

        Map<String, Product> products = ProductTable.getProductMap(productIDList);

        for (RecommendedItem item : items){
            String productID = String.valueOf(item.getItemID());
            Product product = products.get(productID);
            if(product != null){
                RecommendProduct rp = new RecommendProduct(product, item.getValue());
                recommendProducts.add(rp);
            }
        }
    }

    public List<RecommendProduct> getRecommendProducts() {
        return recommendProducts;
    }

    public void setRecommendProducts(List<RecommendProduct> recommendProducts) {
        this.recommendProducts = recommendProducts;
    }

    public String toJSON(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean flag = false;
        for(RecommendProduct product : recommendProducts){
            if(flag){
                sb.append(", ");
            } else {
                flag = true;
            }
            sb.append(product.toJSON());
        }
        sb.append("]");
        return sb.toString();
    }
}
