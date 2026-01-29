SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0
    -- 2번 형질(값 2)을 보유하지 않은 경우
    -- -> GENOTYPE의 이진수에서 '2의 자리(bit)'가 0이라는 뜻
    
    AND (GENOTYPE & 5) > 0;
    -- 1번(1) 또는 3번(4) 형질을 보유한 경우
    -- 5 = 1 | 4(0001 OR 0100 = 0101)
    -- -> 둘 중 하나라도 있으면 AND 결과가 0보다 커짐