import sys

def push(num):
    stack.append(num)


def pop():
    if len(stack) == 0:
        return -1
    else:
        return stack.pop()


def size():
    return len(stack)


def isEmpty():
    if len(stack) == 0:
        return 1
    else:
        return 0


def top():
    if len(stack) == 0:
        return -1
    else:
        return stack[-1]


N = int(input())
stack = []
for _ in range(N):

    # 두 개 입력할 때는 split을 적용하여 인덱스로 접근
    command = sys.stdin.readline().split()

    if command[0] == 'push':
        push(int(command[1]))
    elif command[0] == 'pop':
        print(pop())
    elif command[0] == 'size':
        print(size())
    elif command[0] == 'empty':
        print(isEmpty())
    elif command[0] == 'top':
        print(top())

