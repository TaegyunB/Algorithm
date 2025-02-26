S = input()

len_S = len(S)

i = 0
stack = []

while i < len_S:

    # 시작 태그 & 끝 태그
    if S[i] == '<':  # '<' 이면
        while S[i] != '>':  # '>' 만날 때까지 stack에 추가
            stack += S[i]
            i += 1
        stack += S[i]
        i += 1

    if i == len_S:  # i와 길이가 같으면 break
        break

    # 중간
    temp_stack = []
    while S[i] != " " and S[i] != '<':  # 여기서 왜 or을 쓰면 안되지?
        temp_stack += S[i]
        i += 1

        if i == len_S:
            break

    temp_stack = temp_stack[::-1]  # 뒤집어

    for j in range(len(temp_stack)):  # 뒤집은 것을 stack에 추가
        stack += temp_stack[j]

    if i < len_S:
        if S[i] == " ":  # 띄어쓰기일 때 stack에 추가
            stack += S[i]
            i += 1

print("".join(stack))

