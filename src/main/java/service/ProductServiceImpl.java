package service;

import api.ProductService;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;
    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getCountAllProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {

        for (Product product: products) {
            if(product.getProductName().equals(productName))
                return product;
        }
        return null;
    }

    @Override
    public boolean isMoreProductsThanZeroByProductName(String productName) {
        for (Product product:products) {
            if(product.getProductName().equals(productName)){
                if(product.getProductCount() > 0)
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExistByProductName(String productName) {
        for(Product product: products){
            if(product.getProductName().equals(productName))
                return true;
        }
        return false;
    }

    @Override
    public boolean isProductExistByProductId(long id) {
        for(Product product:products){
            if (product.getId() == id)
                return true;
        }
        return false;
    }
}
