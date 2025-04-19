package com.gnstudy.item_management.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingFee {
    @Schema(description = "기본 요금" , example = "2000")
    private long baseFee;
    @Schema(description = "기본 시간" , example = "30")
    private long freeTime;
    @Schema(description = "추가 요금 시간 단위" , example = "10")
    private long additionalFee;
    @Schema(description = "추가 요금" , example = "1000")
    private long additionalTime;
}
