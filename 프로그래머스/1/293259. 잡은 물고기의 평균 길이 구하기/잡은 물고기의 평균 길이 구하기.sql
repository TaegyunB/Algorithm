SELECT ROUND(AVG(IFNULL(length, 10)), 2) as AVERAGE_LENGTH
FROM fish_info;

# IFNULL(length, 10): length 컬럼의 값이 NULL 이면 10으로 변경, 아니면 값 그대로 사용
# AVG(...): 모든 행에 대해 평균을 계산
# ROUND(..., 2): 소수점 3째 자리에서 반올림