package com.fann.service;

import com.fann.common.ServerResponse;
import com.fann.pojo.Shipping;
import com.github.pagehelper.PageInfo;

/**
 * Created by b1109_000 on 2017/5/13.
 */
public interface IShippingService {
    public ServerResponse add(Integer userId, Shipping shipping);
    public ServerResponse<String> del(Integer userId,Integer shippingId);
    public ServerResponse update(Integer userId,Shipping shipping);
    public ServerResponse<Shipping> select(Integer userId , Integer shippingId);
    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
