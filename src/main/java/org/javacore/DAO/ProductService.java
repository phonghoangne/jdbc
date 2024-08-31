package org.javacore.DAO;

import org.javacore.domain.Product;

import java.util.Comparator;
import java.util.List;

public interface ProductService extends CRUD<Product>{

    List<Product> findProductItemOfComBo(Integer productId);
    List<Product> orderByOnHand();
}
