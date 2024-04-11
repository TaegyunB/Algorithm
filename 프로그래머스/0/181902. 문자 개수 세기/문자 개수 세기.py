# 다른 풀이
def solution(my_string):
    answer = [0] * 52

    for x in my_string:
        if x.isupper():
            answer[ord(x)-65] += 1 
            # 대문자 알파벳의 ASCII 코드 값 범위는 65(A)부터 90(Z)
            # 'ord(x) - 65'를 사용하여 해당하는 대문자 알파벳의 인덱스를 구함
            # 'ord()' 함수는 문자를 해당하는 ASCII 코드 값으로 변환
        else:
            answer[ord(x)-71] += 1
            # 소문자 알파벳의 ASCII 코드 값 범위는 97(a)부터 122(z)
            # 'ord(x) - 71'을 사용하여 해당하는 소문자 알파벳의 인덱스를 구함

    return answer

# 내 풀이
def solution(my_string):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    answer = [0] * len(alphabet)
    
    for i in range(len(alphabet)):
        if alphabet[i] in my_string:
            answer[i] += my_string.count(alphabet[i])
    
    return answer
