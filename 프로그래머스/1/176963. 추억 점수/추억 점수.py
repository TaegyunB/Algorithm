def solution(name, yearning, photo):
    answer = []
    
    # 이차원 문자열 배열만큼 반복
    for i in range(len(photo)):
        sum = 0
        for j in range(len(photo[i])):
            if photo[i][j] in name:
                index_in_name = name.index(photo[i][j])
                sum += yearning[index_in_name]
            else:
                continue
        answer.append(sum)
    
    return answer