SELECT fh.FLAVOR 
FROM FIRST_HALF fh
INNER JOIN (
    # JULY 테이블은 같은 FLAVOR가 여러 행으로 존재할 수 있음
    # 바로 JOIN하면 딸기가 2번 매칭되어 중복 계산되는 문제 발생
    # 따라서 서브쿼리로 FLAVOR별 TOTAL_ORDER를 미리 합산하여 임시 테이블 생성
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM JULY
    GROUP BY FLAVOR
) f ON fh.FLAVOR = f.FLAVOR
# FIRST_HALF(상반기) 기준 LEFT JOIN 사용 이유:
# 상반기엔 팔렸지만 7월엔 팔리지 않은 FLAVOR가 있을 수 있음
# INNER JOIN 사용 시 해당 FLAVOR는 결과에서 제외되므로 LEFT JOIN 사용
ORDER BY fh.TOTAL_ORDER + IFNULL(f.TOTAL_ORDER, 0) DESC
# 상반기 주문량 + 7월 주문량 합산
LIMIT 3;