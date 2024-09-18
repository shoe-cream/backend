package com.springboot.item.repository;

import com.springboot.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemCd(String itemCd);
    Page<Item> findByItemNm(String itemNm, Pageable pageable);
    List<Item> findAll();
    boolean existsByItemCd(String itemCd);
    boolean existsByItemNm(String itemNm);
    Optional<Item> findByItemId(Long itemId);
    Optional<Item> findByItemNm(String itemNm);
    Page<Item> findAllByItemStatusNot(Item.ItemStatus itemStatus, Pageable pageable);
    List<Item> findAllByItemStatusNot(Item.ItemStatus itemStatus);
}
