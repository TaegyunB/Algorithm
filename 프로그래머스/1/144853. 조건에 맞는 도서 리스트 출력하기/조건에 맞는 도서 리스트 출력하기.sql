SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
-- DATE_FORMAT을 사용해 날짜 형식을 'YYYY-MM-DD' 형태로 변환

FROM BOOK
WHERE PUBLISHED_DATE LIKE '2021-__-__'
-- 출판일이 2021년인 데이터만 조회
-- '__'는 월과 일을 의미하는 와일드카드 (한 글자씩 총 2글자)

AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE;