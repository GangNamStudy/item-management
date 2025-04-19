package com.gnstudy.item_management.service;

import com.gnstudy.item_management.domain.ParkingFee;
import com.gnstudy.item_management.repository.MemoryDatabase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingFeeManagementTest {

    static private MemoryDatabase database;

    @BeforeAll
    static void initTest()
    {
        database=new MemoryDatabase();
    }

    @Test
    @DisplayName("DB에서 가격 정책을 가져올 수 있다.")
    void getPriceInfo() {
        //given
        ParkingFeeManagement parkingFeeManagement=new ParkingFeeManagement(ParkingFeeManagementTest.database);
        //when
        ParkingFee result=parkingFeeManagement.getPriceInfo();
        //then
        assertNotNull(result);
    }

    @Test
    @DisplayName("DB에서 가격 정책을 저장할 수 있다.")
    void changePrice() {
        ParkingFeeManagement parkingFeeManagement=new ParkingFeeManagement(ParkingFeeManagementTest.database);
        //given
        ParkingFee parkingFee=new ParkingFee(2000,30,1000,40);
        //when
        parkingFeeManagement.changePrice(parkingFee);
        ParkingFee resultParkingFee=parkingFeeManagement.getPriceInfo();
        //then
        assertEquals(parkingFee.getBaseFee(),resultParkingFee.getBaseFee());
        assertEquals(parkingFee.getFreeTime(),resultParkingFee.getFreeTime());
        assertEquals(parkingFee.getAdditionalFee(),resultParkingFee.getAdditionalFee());
        assertEquals(parkingFee.getAdditionalTime(),resultParkingFee.getAdditionalTime());

    }
}