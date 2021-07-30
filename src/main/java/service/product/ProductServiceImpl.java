package service.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findOneById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findALlByPName(String name) {
        return productRepository.findALlByPName(name);
    }

    @Override
    public Iterable<Product> findAllByCategoryId(long id) {
        return productRepository.findAllByCategoryId(id);
    }
}
