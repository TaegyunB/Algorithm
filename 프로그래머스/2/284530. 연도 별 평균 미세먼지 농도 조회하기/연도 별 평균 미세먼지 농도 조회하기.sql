SELECT 
    YEAR(YM) AS YEAR,
    ROUND(AVG(PM_VAL1), 2) AS "PM10", 
    ROUND(AVG(PM_VAL2), 2) AS "PM2.5"
FROM 
    AIR_POLLUTION
WHERE 
    LOCATION2 = "수원"
GROUP BY 
    YEAR(YM)  # 각 행의 날짜에서 연도 숫자만 뽑아냄
    
# FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY 순으로 처리 되기 때문에
# ORDER BY에 SELECT 별칭을 사용해도 됨
ORDER BY
    YEAR;
    
