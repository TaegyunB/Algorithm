def solution(my_strings, parts):
    answer = ''
    
    for i in range(len(parts)):
        word = my_strings[i]
        word_parts = word[parts[i][0] : parts[i][1] + 1]
        answer += word_parts
            
    
    return answer