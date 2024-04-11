def solution(my_string):
    answer = []
    
    for i in range(len(my_string)):
        answer.append(my_string[i:len(my_string)])
        
    answer.sort()
    # 위 코드 지우고
        
    return answer
    # return sorted(answer)를 사용해도 됨