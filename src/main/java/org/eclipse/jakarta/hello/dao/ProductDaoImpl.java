package org.eclipse.jakarta.hello.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.eclipse.jakarta.hello.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
           entityTransaction.begin(); // Begin transaction before interacting with EntityManager
            products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            entityTransaction.commit();

        return products;
    }


    @Override
    public void addProduct(String name, double price) {
        try {
            entityTransaction.begin();
            Product product = new Product();
            product.setProductName(name);
            product.setPrice(price);
            entityManager.persist(product);
            entityTransaction.commit();
        } catch (RuntimeException ex) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw ex; // Re-throw the exception to propagate it further
        }
    }

    @Override
    public void deleteProduct(int id) {
        entityTransaction.begin();
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public void updateProduct(int id, String name, double price) {
        entityTransaction.begin();
        Product product = entityManager.find(Product.class,id);
        product.setProductName(name);
        product.setPrice(price);
        entityManager.merge(product);
        entityTransaction.commit();
    }


}
