package org.eclipse.jakarta.hello.dao;

public class ProductSingleton {


    private static class LazyLoad {
//        static final ProductSingleton INSTANCE = new ProductSingleton();
        static final ProductDao INSTANCE = new ProductDaoImpl();
    }

    private ProductSingleton(){}
    public static ProductDao getInstance(){
        return LazyLoad.INSTANCE;
    }


}
