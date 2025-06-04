package com.gnstudy.item_management.repository;

import com.gnstudy.item_management.domain.ParkingFee;

public interface DataBase {
    public ParkingFee getPriceTable();
    public void savePriceTable(ParkingFee parkingFee);
}
