-- 코드를 입력하세요
select A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, DATE_FORMAT(B.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from used_goods_board as A, used_goods_reply as B
where A.board_id = B.board_id
and A.created_date like "2022-10%"
order by B.created_date, A.title