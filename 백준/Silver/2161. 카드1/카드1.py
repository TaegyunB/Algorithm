# N = int(input())
# stack = [0] * (N * N)
# top = -1
#
# for i in range(1, N+1):
#     top += 1
#     stack[top] = i
#
# top = -1
# for i in range(N):
#     # 버릴 것
#     top += 1
#     print(stack[top], end=" ")
#
#     # 밑으로 이동
#     stack[N + top] = stack[top+1]
#     top += N - i
#
#
# print(stack)
# print(stack[N])
#
#


N = int(input())

stack = [0] * N

for i in range(N):
    stack[i] = i + 1

for i in range(N-1):
    # 첫 번째 버림
    print(stack.pop(0), end=" ")

    # 아래로 이동
    move_num = stack.pop(0)
    stack.append(move_num)


print(stack[0])