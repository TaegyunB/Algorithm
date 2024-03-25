-- 코드를 작성해주세요
select concat(length, "cm") as MAX_LENGTH from fish_info order by length desc limit 1

# concat(): 문자열을 결합하는 데 사용
# concat(length, "cm"): 해당 열의 값을 cm단위로 표시하기 위함