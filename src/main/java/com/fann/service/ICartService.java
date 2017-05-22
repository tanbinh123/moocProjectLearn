package com.fann.service;

import com.fann.common.ServerResponse;
import com.fann.vo.CartVo;

/**
 * Created by b1109_000 on 2017/5/8.
 */

public interface ICartService {
    public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    public ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    public ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    public ServerResponse<CartVo> list(Integer userId);

    public ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId,Integer checked);

    public ServerResponse<Integer> getCartProductCount(Integer userId);
}
