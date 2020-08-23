package service;

import api.ProductService;
import com.sun.org.apache.bcel.internal.classfile.AttributeReader;
import models.Boots;
import models.Cloth;
import models.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class ProductServiceTest {


    @Test
    public void testGetAllProductsPositive() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl userService = new ProductServiceImpl(products);
        List<Product> listFromTestClass = userService.getAllProducts();

        Assert.assertEquals(products, listFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        //new ArrayList<Product>(products) - utworzenie kopii listy, więcej o kopiowaniu i adresach w 4 tygodniu
        //dzieki wykonaniu kopii mamy dwa różne obiekty zamiast jedngo
        //jeden siedzi w productService, drugi w naszym tescie
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3l, "Spodnie", 44.f, 0.f, "White", 3, "S", "COTTON"));
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetCountProductsWithProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountAllProducts();

        Assert.assertEquals(2, result);
    }


    @Test
    public void testGetCountProductsWithoutProducts() {
        ProductServiceImpl productService = new ProductServiceImpl();

        final int result = productService.getCountAllProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("T-SHIRT");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("JAKIS-PRODUKT");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWareHouseWhenIs() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isMoreProductsThanZeroByProductName("Boots");

        Assert.assertTrue(isProductOnWareHouse);
    }


    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isMoreProductsThanZeroByProductName("Boots");

        Assert.assertFalse(isProductOnWareHouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExistByProductName("Boots");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExistByProductName("Inny produkt");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExistByProductId(2l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExistByProductId(5l);

        Assert.assertFalse(isProductExist);
    }


}

//public class ProductServiceTest {
//
//    @Test
//    public void testGetAllProductsPositive(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
//        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));
//
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        List<Product> productsFromGetAllProducts = productService.getAllProducts();
//
//        //expected
//        Assert.assertEquals(products, productsFromGetAllProducts);
//
//    }
//
//    @Test
//    public void testGetAllProductsNegative(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
//        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));
//
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        products.add(new Cloth(3l, "Spodnie", 44.f, 0.f, "White", 3, "S", "COTTON"));
//        List<Product> productsFromGetAllProducts = productService.getAllProducts();
//
//        //expected
//        Assert.assertNotEquals(products, productsFromGetAllProducts);
//
//    }
//
//    @Test
//    public void testGetCountAllProducts(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
//        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        final int result = productService.getCountAllProducts();
//
//        //expected
//        Assert.assertEquals(2, result);
//
//    }
//
//    @Test
//    public void testGetACountAllProductsWithoutProducts(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        final int result = productService.getCountAllProducts();
//
//        //expected
//        Assert.assertNotEquals(4, result);
//
//    }
//
//    @Test
//    public void testGetProductByProductNameWhenExist(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//        products.add(new Boots(2l, "Adidas", 120.0f, 0.3f, "black", 20, 42, false));
//
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        Product product = productService.getProductByProductName("Kurtka");
//
//        //expected
//        Assert.assertEquals(products.get(0), product);
//    }
//
//    @Test
//    public void testGetProductByProductNameWhenNoExist(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        Product result = productService.getProductByProductName("Kurtka");
//
//        //expected
//        Assert.assertEquals(null, result);
//
//    }
//
//    @Test
//    public void testGetCountProductByProductNamePositive(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//        products.add(new Boots(2l, "Adidas", 120.0f, 0.3f, "black", 20, 42, false));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isMoreProductsThanZeroByProductName("Kurtka");
//
//        //expected
//        Assert.assertTrue(result);
//    }
//
//    @Test
//    public void testGetCountProductByProductNameNegative(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//        products.add(new Boots(2l, "Adidas", 120.0f, 0.3f, "black", 0, 42, false));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isMoreProductsThanZeroByProductName("Adidas");
//
//        //expected
//        Assert.assertFalse(result);
//
//    }
//
//    @Test
//    public void testIsProductExistByProductName(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//        products.add(new Boots(2l, "Adidas", 120.0f, 0.3f, "black", 0, 42, false));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isProductExistByProductName("Kurtka");
//
//        //expected
//        Assert.assertTrue(result);
//
//    }
//
//    @Test
//    public void testIsProductNoExistByProductName(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//        products.add(new Boots(2l, "Adidas", 120.0f, 0.3f, "black", 0, 42, false));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isProductExistByProductName("Bluza");
//
//        //expected
//        Assert.assertFalse(result);
//
//    }
//
//
//    @Test
//    public void testIsProductExistByProductId(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Boots(1l, "Trampki", 89.9f, 0.3f, "White", 20, 39,false));
//        products.add(new Cloth(2l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isProductExistByProductId(2);
//
//        //expected
//        Assert.assertTrue(result);
//
//    }
//
//    @Test
//    public void testIsProductNoExistByProductId(){
//
//        //is
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Boots(1, "Trampki", 89.9f, 0.3f, "White", 20, 39,false));
//        products.add(new Cloth(1l, "Kurtka",20.0f, 0.4f, "red", 20, "M", "leather"));
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
//        boolean result = productService.isProductExistByProductId(3);
//
//        //expected
//        Assert.assertFalse(result);
//
//    }
//}
