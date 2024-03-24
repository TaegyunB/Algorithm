def solution(num_list):
    answer = 0
    
    sum = 0
    mul = 1
    
    for i in range(len(num_list)):
        sum += num_list[i]
        mul *= num_list[i]
        
    if sum ** 2 > mul:
        answer = 1
    else:
        answer = 0
        
    return answer