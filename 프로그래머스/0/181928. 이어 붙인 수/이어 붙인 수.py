def solution(num_list):
    
    str_even = ""
    str_odd = ""
    
    for i in range(len(num_list)):
        if num_list[i] % 2 == 0:
            str_even += str(num_list[i])
        else:
            str_odd += str(num_list[i])
    
    answer = int(str_even) + int(str_odd)
    
    return answer