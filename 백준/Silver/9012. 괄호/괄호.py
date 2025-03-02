T = int(input())

for tc in range(T):
    ps = input()
    cnt = 0

    for word in ps:
        if word == '(':
            cnt += 1
        elif word == ')':
            cnt -= 1
            if cnt < 0:
                break
            

    if cnt == 0:
        print("YES")
    else:
        print("NO")