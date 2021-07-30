package formatter;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.category.CategoryServiceImpl;
import service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {

    ICategoryService categoryService;

    public <T> CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }




    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return this.categoryService.findOneById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
