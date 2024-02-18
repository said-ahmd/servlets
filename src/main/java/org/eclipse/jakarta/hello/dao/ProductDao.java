package org.eclipse.jakarta.hello.dao;

import org.eclipse.jakarta.hello.Entity.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProducts();
    public void addProduct(String name, double price);
    public void deleteProduct(int id);
    public void updateProduct(int id,String name,double price);
}
