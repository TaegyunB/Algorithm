import sys

n = int(sys.stdin.readline())
stack = []

for i in range(n):
    m = sys.stdin.readline().split()
    
    if m[0] == "1":
        stack.append(m[1])
        
    elif m[0] == "2":
        if stack: # 만약에 stack이 비어 있지 않으면
            print(stack.pop())
        else:
            print("-1")
            
    elif m[0] == "3":
        print(len(stack))
        
    elif m[0] == "4":
        if stack:
            print("0")
        else:
            print("1")
            
    elif m[0] == "5":
        if stack:
            print(stack[-1])
        else:
            print("-1")