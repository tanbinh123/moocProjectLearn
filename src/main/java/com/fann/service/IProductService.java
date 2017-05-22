package com.fann.service;

import com.fann.common.ServerResponse;
import com.fann.pojo.Product;
import com.fann.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by b1109_000 on 2017/5/4.
 */
public interface IProductService {

    public ServerResponse saveOrUpdateProduct(Product product);

    public ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    public ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    public ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    public ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pagSize, String orderBy);
}
