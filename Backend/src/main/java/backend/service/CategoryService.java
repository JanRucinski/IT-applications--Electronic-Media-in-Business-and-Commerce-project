package backend.service;

import backend.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);

    boolean deleteCategory(Long id);

    List<Category> findAllCategories();

    Category updateCategory(Long id, Category category);

    Category findCategoryById(Long id);
}