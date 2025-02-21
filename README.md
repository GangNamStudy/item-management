# item-management
주차 요금 관리

- **기반**: Spring Boot
- **기능**:
  - 주차 요금 관리
  - 기본 주차요금, 기본 제공 시간, 추가 요금 설정 및 조정 가능
  - 결제 내역 조회 및 정산 처리

#### **1. 주차 요금 조회 기능 (GET)**

- **URL**: `/api/parking-fees/policy`
- **설명**: 현재 적용된 주차 요금 정책을 조회
- **예제 cURL 요청**:
  ```bash
  curl -X GET "http://localhost:8080/api/parking-fees/policy" -H "Content-Type: application/json"
  ```
- **예제 응답**:
  - **HTTP Status**: 200 OK
  ```json
  {
    "baseFee": 1000,
    "freeTime": 30,
    "additionalFee": 500,
    "additionalTime": 10
  }
  ```

#### **2. 주차 요금 수정 기능 (PATCH)**

- **URL**: `/api/parking-fees`
- **Body Parameters**:
  - `baseFee`: 기본 요금
  - `freeTime`: 무료 제공 시간 (분)
  - `additionalFee`: 추가 요금
  - `additionalTime`: 추가 요금 부과 시간 단위 (분)
- **설명**: 주차 요금제 등록 및 조정
- **예제 cURL 요청**:
  ```bash
  curl -X PATCH "http://localhost:8080/api/parking-fees" \
  -H "Content-Type: application/json" \
  -d '{"baseFee": 1000, "freeTime": 30, "additionalFee": 500, "additionalTime": 10}'
  ```
- **예제 응답**:
  - **HTTP Status**: 200 OK
  ```json
  {
    "baseFee": 1000,
    "freeTime": 30,
    "additionalFee": 500,
    "additionalTime": 10
  }
  ```
