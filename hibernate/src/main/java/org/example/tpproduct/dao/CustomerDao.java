package org.example.tpproduct.dao;

import org.example.tpproduct.models.Customer;
import org.example.tpproduct.models.articles.Article;

public class CustomerDao extends BaseDao<Customer> {
    public CustomerDao() {
        super(Customer.class);
    }
}
