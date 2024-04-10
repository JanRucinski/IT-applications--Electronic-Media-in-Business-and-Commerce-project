package backend.service;

import backend.model.Category;
import backend.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category deleteCategory(long id) {
        return null;
    }

    @Override
    public List<Category> findAllCategories() {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public Category findCategoryById(long id) {
        return null;
    }
}
