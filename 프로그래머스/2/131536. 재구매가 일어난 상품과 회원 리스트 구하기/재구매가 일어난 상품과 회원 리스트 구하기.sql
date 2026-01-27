SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
-- 회원 ID + 상품 ID 조합으로 묶음
-- 같은 회원이 같은 상품을 몇 번 구매했는지 확인하기 위함

HAVING COUNT(*) >= 2
-- 해당 회원이 동일한 상품을 2번 이상 구매한 경우만 사용

ORDER BY USER_ID ASC, PRODUCT_ID DESC;