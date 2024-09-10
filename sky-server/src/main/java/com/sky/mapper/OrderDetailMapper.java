package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 批量插入数据
     * @param detaillist
     */
    void insert(List<OrderDetail> detaillist);

    /**
     * 根据订单id查询详情
     * @param orderId
     * @return
     */
    @Select("select * from order_detail where  order_id =#{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);

}
