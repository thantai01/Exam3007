package service.category;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

import java.util.Optional;
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findOneById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
