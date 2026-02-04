SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR

-- "가죽시트,열선시트,후방카메라"처럼 콤마로 구분된 여러 옵션의 조합이므로, IN 절로는 찾을 수 없음
WHERE OPTIONS LIKE "%통풍시트%"
    OR OPTIONS LIKE "%열선시트%"
    OR OPTIONS LIKE "%가죽시트%"
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE;