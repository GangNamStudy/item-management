package com.gnstudy.item_management.repository;

import com.gnstudy.item_management.domain.ParkingFee;
import org.springframework.stereotype.Component;

@Component
public class MemoryDatabase implements DataBase{
    private ParkingFee data;
    public MemoryDatabase(){
        data=new ParkingFee(1000,30,100,10);
    }

    @Override
    public ParkingFee getPriceTable() {
        return data;
    }

    @Override
    public void savePriceTable(ParkingFee parkingFee) {
        data=parkingFee;
    }
}
