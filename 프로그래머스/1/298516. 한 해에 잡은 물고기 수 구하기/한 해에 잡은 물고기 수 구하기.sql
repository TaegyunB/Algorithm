-- 코드를 작성해주세요

select count(*) as FISH_COUNT from FISH_INFO where year(time) = '2021'
-- where month(time): 월, where day(time): 일
