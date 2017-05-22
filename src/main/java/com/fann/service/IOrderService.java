package com.fann.service;

import com.fann.common.ServerResponse;
import com.fann.vo.OrderVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * Created by b1109_000 on 2017/5/17.
 */
public interface IOrderService {
    public ServerResponse pay(Long orderNo, Integer userId, String path);
    public ServerResponse aliCallback(Map<String,String> params);
    public ServerResponse queryOrderPayStatus(Integer userId,long orderNo);
    public ServerResponse createOrder(Integer userId,Integer shippingId);
    public ServerResponse<String> cancel(Integer userId,long orderNo);
    public  ServerResponse getOrderCartProduct(Integer userId);
    public ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
    public ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);


    public ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
    public ServerResponse<OrderVo> manageDetail(Long orderNo);
    public ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);
    public ServerResponse<String> manageSendGoods(Long orderNo);
}
