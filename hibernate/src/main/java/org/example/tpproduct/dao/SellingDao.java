package org.example.tpproduct.dao;

import org.example.productexercise.models.Article;
import org.example.tpproduct.models.selling.Selling;

public class SellingDao extends BaseDao<Selling> {
    public SellingDao() {
        super(Selling.class);
    }
}
