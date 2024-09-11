package com.springboot.order_header.dto;

import com.springboot.order_header.entity.OrderHeaders;
import com.springboot.order_item.entity.OrderItems;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    @Getter
    public static class Post {
        @NotNull(message = "buyerCd가 누락되었습니다.")
        private String buyerCd;
        @NotNull(message = "item은 Cd, 단가, 수량, 시작일, 종료일, 단위가 모두 필요합니다.")
        private List<OrderItemDto> orderItems;
        @NotNull(message = "납기일이 누락되었습니다.")
        private LocalDateTime requestDate;
    }

    @Getter
    public static class OrderPatch {
        @Setter
        private Long orderId;
        private LocalDateTime requestDate;
        private OrderHeaders.OrderStatus orderStatus;
    }

    @Getter
    public static class ItemPatch {
        private BigDecimal unitPrice;
        private Long qty;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
    }

    @Builder
    @Getter
    public static class Response {
        private Long orderId;
        private String employeeId;
        private String buyerCd;
        private String buyerNm;
        private LocalDateTime createdAt;
        private LocalDateTime requestDate;
        private OrderHeaders.OrderStatus status;
        private List<OrderItems> orderItems;
    }


    @Getter
    public static class OrderItemDto {
        private String itemCd;
        private BigDecimal unitPrice;
        private Long qty;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String unit;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class OrderSearchRequest {
        private String buyerCd;
        private String itemCd;
        private OrderHeaders.OrderStatus status;
        private Long orderId;

        @DateTimeFormat(pattern = "yyyyMMdd")
        private LocalDate searchStartDate = LocalDate.of(1900, 1, 1);  // 기본값

        @DateTimeFormat(pattern = "yyyyMMdd")
        private LocalDate searchEndDate = LocalDate.of(9999, 12, 31); // 기본값

    }
}

