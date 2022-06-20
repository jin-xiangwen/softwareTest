package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.Category;
import com.tongji.softwaretest.shikebackend.mapper.CategoryMapper;
import com.tongji.softwaretest.shikebackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public List<Category> getGoodsList(int storeId) {
        return categoryMapper.selectByStoreId(storeId);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        return false;
    }

    @Override
    public boolean modifyCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        return false;
    }
}
