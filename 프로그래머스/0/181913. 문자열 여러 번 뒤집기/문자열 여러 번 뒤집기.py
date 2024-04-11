def solution(my_string, queries):
    
    for a, b in queries:
        k = my_string[a:b+1]
        rev_k = k[::-1]
        
        my_string = my_string[:a] + rev_k + my_string[b+1:]

    return my_string