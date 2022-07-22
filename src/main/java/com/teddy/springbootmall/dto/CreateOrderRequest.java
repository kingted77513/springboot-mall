package com.teddy.springbootmall.dto;

import com.teddy.springbootmall.constant.ProductCategory;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateOrderRequest {

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }

    @NotEmpty
    private List<BuyItem> buyItemList;
}
