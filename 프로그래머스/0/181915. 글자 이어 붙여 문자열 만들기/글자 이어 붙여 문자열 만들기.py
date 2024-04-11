# 간단한 풀이
def solution(my_string, index_list):
    return ''.join([my_string[idx] for idx in index_list]) # 리스트 컴프리헨션을 사용하여 'index_list'에 있는 각 인덱스에 대해 해당하는 문자를 선택함

# 내 풀이
def solution(my_string, index_list):
    answer = ''
    
    for i in index_list:
        answer += my_string[i]
    
    return answer
