package com.fann.service;

import com.fann.common.ServerResponse;
import com.fann.pojo.Category;

import java.util.List;
import java.util.Set;

/**
 * Created by b1109_000 on 2017/5/3.
 */
public interface ICategoryService {
    public ServerResponse addCategory(String categoryName, Integer parentId);

    public ServerResponse updateCategoryName(Integer categoryId,String categoryName);

    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
