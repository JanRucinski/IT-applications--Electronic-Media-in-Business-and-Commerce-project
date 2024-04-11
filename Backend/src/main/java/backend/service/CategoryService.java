package backend.service;

import backend.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    Category deleteCategory(long id);
    List<Category> findAllCategories();
    Category updateCategory(Category category);
    Category findCategoryById(long id);
}