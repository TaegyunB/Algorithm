def solution(my_string, is_prefix):
    answer = 0
    word = []
    
    for i in range(len(my_string)):
        word.append(my_string[:i])

    if is_prefix in word:
        answer = 1
    
    return answer