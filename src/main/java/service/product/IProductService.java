package service.product;

import model.Product;
import service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findALlByPName(String name);

    Iterable<Product> findAllByCategoryId(long id);
}
