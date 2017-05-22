package com.fann.service.impl;

import com.fann.common.ResponseCode;
import com.fann.common.ServerResponse;
import com.fann.dao.CategoryMapper;
import com.fann.pojo.Category;
import com.fann.pojo.Product;
import com.fann.service.ICategoryService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by b1109_000 on 2017/5/3.
 */

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private CategoryMapper categoryMapper;

    public ServerResponse addCategory(String categoryName,Integer parentId){
        if(StringUtils.isBlank(categoryName) || parentId == null){
                return ServerResponse.createByErrorMessage("添加商品参数错误");
        }
        Category category = new Category();
        category.setParentId(parentId);
        category.setName(categoryName);
        category.setStatus(true);
        int rowCount = categoryMapper.insert(category);
        if(rowCount > 0){
            return ServerResponse.createBySuccessMessage("添加商品类别成功");
        }
        return ServerResponse.createByErrorMessage("添加商品类别失败");
    }

    public ServerResponse updateCategoryName(Integer categoryId,String categoryName){
        if(categoryId == null || StringUtils.isBlank(categoryName)){
            return ServerResponse.createByErrorMessage("修改商品名称参数错误");
        }
        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        int updateCount = categoryMapper.updateByPrimaryKeySelective(category);
        if(updateCount >0){
            return ServerResponse.createBySuccessMessage("修改商品名称成功");
        }
        return ServerResponse.createByErrorMessage("修改商品名称失败");
    }

    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId){
            List<Category> list = categoryMapper.selectCategoryChildrenByParentId(categoryId);
            if(CollectionUtils.isEmpty(list)){
                logger.info("未找到当前分类的子分类");
            }
        return ServerResponse.createBySuccess(list);
    }

    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId){
            Set<Category> categortSet = Sets.newHashSet();
            findChildrenCategory(categortSet,categoryId);
            List<Integer> categoryIdlist = Lists.newArrayList();
            for (Category category:categortSet){
                categoryIdlist.add(category.getId());
            }
             return ServerResponse.createBySuccess(categoryIdlist);
    }

    public Set<Category> findChildrenCategory(Set<Category> categorySet, Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null ){
            categorySet.add(category);
        }
        //递归算法,算出子节点
        List<Category> list = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for(Category categoryItem:list){
            findChildrenCategory(categorySet,categoryItem.getId());
        }
        return categorySet;

    }

}
