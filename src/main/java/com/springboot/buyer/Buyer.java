package com.springboot.buyer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springboot.buyer_item.entity.BuyerItem;
import com.springboot.order_headers.entity.OrderHeaders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerId;

    @Column(nullable = false)
    private String buyerCd;

    @Column
    private String email;

    @Column(nullable = false)
    private String buyerNm;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String businessType;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BuyerItem> buyerItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "buyerCd", referencedColumnName = "buyerCd")
    @JsonBackReference
    private OrderHeaders orderHeader;
}
