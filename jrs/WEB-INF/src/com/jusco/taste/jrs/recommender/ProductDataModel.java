package com.jusco.taste.jrs.recommender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLJDBCDataModel;

import com.jusco.taste.jrs.utils.DBUtil;


public class ProductDataModel extends PostgreSQLJDBCDataModel {
    public final static String PERFERENCETABLE = "ratings";
    public final static String USERID_COLUMN = "userID";
    public final static String ITEMID_COLUMN = "productID";
    public final static String PERFERENCE_COLUMN = "preference";


    public ProductDataModel(String dataSourceName) throws TasteException {
        super(lookupDataSource(dataSourceName), PERFERENCETABLE, USERID_COLUMN, ITEMID_COLUMN, PERFERENCE_COLUMN);
    }

    public ProductDataModel() {
        super(DBUtil.getDataSource(), PERFERENCETABLE, USERID_COLUMN, ITEMID_COLUMN, PERFERENCE_COLUMN);
    }
}
