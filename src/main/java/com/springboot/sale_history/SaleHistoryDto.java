package com.springboot.sale_history;

import com.springboot.order_header.entity.OrderHeaders;
import com.springboot.order_item.entity.OrderItems;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class SaleHistoryDto {
    private LocalDateTime createdAt;
    private String employeeId;
    private Long orderId;
    private OrderHeaders.OrderStatus orderStatus;
    private LocalDateTime orderDate;
    private LocalDateTime requestDate;
    private String buyerNm;
    private String buyerCd;
    private List<OrderItems> orderItems;

}
