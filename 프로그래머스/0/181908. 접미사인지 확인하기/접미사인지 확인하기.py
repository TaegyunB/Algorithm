def solution(my_string, is_suffix):
    answer = 0
    word = []
    
    for i in range(len(my_string)):
        word.append(my_string[i:len(my_string)])
    
    if is_suffix in word:
        answer = 1
    
    return answer