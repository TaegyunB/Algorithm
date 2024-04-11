def solution(my_string):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    answer = [0] * len(alphabet)
    
    for i in range(len(alphabet)):
        if alphabet[i] in my_string:
            answer[i] += my_string.count(alphabet[i])
    
    return answer