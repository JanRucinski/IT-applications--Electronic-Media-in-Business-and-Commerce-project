package backend.service;

import backend.model.Category;

import java.util.List;

interface CategoryService {
    Category addCategory(Category category);
    Category deleteCategory(long id);
    List<Category> findAllCategories();
    Category updateCategory(Category category);
    Category findCategoryById(long id);
}