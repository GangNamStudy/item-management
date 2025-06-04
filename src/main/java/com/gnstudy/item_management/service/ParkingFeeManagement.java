package com.gnstudy.item_management.service;

import com.gnstudy.item_management.domain.ParkingFee;
import com.gnstudy.item_management.repository.DataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingFeeManagement {

    private final DataBase dataBase;
    public ParkingFee getPriceInfo()
    {
        return dataBase.getPriceTable();
    }

    public void changePrice(ParkingFee newPrice){
        dataBase.savePriceTable(newPrice);
    }
}
