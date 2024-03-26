def solution(l, r):
    answer = []
    
    for i in range(l, r+1):
        if all(num in ['0', '5'] for num in str(i)): 
            # 'i'의 모든 자리수가 '0' 또는 '5'으로만 이루어져 있을 때만 참을 반환
            # all(): 모든 요소가 참이면 참을 반환하는 파이썬 내장 함수
            answer.append(i)
        else:
            continue
            
    if len(answer) == 0:
        answer.append(-1)
                
    return answer