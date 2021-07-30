package repository;

import model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    @Query("select product from Product product where product.pName =?1")
    Iterable<Product> findALlByPName(String name);

    Iterable<Product> findAllByCategoryId(long id);
}
