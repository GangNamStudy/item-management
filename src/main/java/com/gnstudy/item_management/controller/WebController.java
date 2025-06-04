package com.gnstudy.item_management.controller;

import com.gnstudy.item_management.domain.ParkingFee;
import com.gnstudy.item_management.service.ParkingFeeManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parking-fee")
public class WebController {
    private final ParkingFeeManagement parkingFeeManagement;

    @GetMapping
    @Operation(
            summary = "주차 요금표 조회",
            description ="현재 적용된 주차 요금 정책을 조회"
    )
    @ApiResponses(value={
            @ApiResponse(responseCode = "200" , description = "조회 결과",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParkingFee.class)))
    })
    public ParkingFee getPriceInfo(){
        return parkingFeeManagement.getPriceInfo();
    }
    @PutMapping("/policy")
    @Operation(
            summary = "주차 요금표 수정",
            description ="현재 적용된 주차 요금 정책을 수정"
    )
    @ApiResponses(value={
            @ApiResponse(responseCode = "200" , description = "수정 후 조회 결과",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParkingFee.class)))
    })
    public ParkingFee changePolicy(@RequestBody ParkingFee parkingFee){
        parkingFeeManagement.changePrice(parkingFee);
        return parkingFeeManagement.getPriceInfo();
    }

}
