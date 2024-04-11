def solution(my_string, s, e):
    
    k = my_string[s:e+1]
    k_rev = k[::-1]
    
    return my_string[:s] + k_rev + my_string[e+1:]