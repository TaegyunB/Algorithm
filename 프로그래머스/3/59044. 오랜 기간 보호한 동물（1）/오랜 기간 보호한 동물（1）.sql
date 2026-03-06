SELECT  ai.NAME, ai.DATETIME
FROM ANIMAL_INS ai
LEFT JOIN ANIMAL_OUTS ao
    ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ao.ANIMAL_ID IS NULL
# 입양 기록이 없는 동물만 선택
# LEFT JOIN 결과에서 OUTS 테이블이 매칭되지 않으면 NULL이 됨
# 즉, 아직 입양되지 않은 동물만 필터링
ORDER BY ai.DATETIME
LIMIT 3;