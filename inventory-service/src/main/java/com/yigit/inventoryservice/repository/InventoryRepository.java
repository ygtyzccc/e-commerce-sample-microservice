package com.yigit.inventoryservice.repository;

import com.yigit.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select i from Inventory i where i.skuCode in ?1")
List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
