package edu.hit.lch.service.impl;

import edu.hit.lch.dao.CategoryDao;
import edu.hit.lch.dao.impl.CategoryDaoImpl;
import edu.hit.lch.domain.Category;
import edu.hit.lch.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
