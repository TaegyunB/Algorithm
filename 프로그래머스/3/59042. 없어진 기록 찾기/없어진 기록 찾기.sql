SELECT ao.ANIMAL_ID, ao.NAME
FROM ANIMAL_OUTS ao

# 퇴소 기록은 모두 가져오고, 입소 기록은 있으면 연결, 없으면 NULL
LEFT JOIN ANIMAL_INS ai
    ON ao.ANIMAL_ID = ai.ANIMAL_ID
WHERE ai.ANIMAL_ID IS NULL
ORDER BY ao.ANIMAL_ID;

# LEFT JOIN: 왼쪽 테이블에는 있지만 오른쪽 테이블에는 없는 것