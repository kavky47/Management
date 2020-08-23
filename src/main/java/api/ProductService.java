package api;

import models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    public int getCountAllProducts();
    public Product getProductByProductName(String productName);
    public boolean isMoreProductsThanZeroByProductName(String productName);
    public boolean isProductExistByProductName(String productName);
    public boolean isProductExistByProductId(long id);

}
