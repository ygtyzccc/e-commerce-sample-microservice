package com.yigit.inventoryservice.controller;

import com.yigit.inventoryservice.dto.InventoryResponse;
import com.yigit.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getStockInfo(@RequestParam List<String> skuCodes){
        return inventoryService.getStockInfo(skuCodes);
    }
}
