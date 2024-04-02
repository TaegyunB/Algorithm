# 간단한 식
def solution(ineq, eq, n, m):
    return int(eval(str(n) + ineq + eq.replace("!", "") + str(m)))


# 내 풀이
# def solution(ineq, eq, n, m):
#     answer = 0
    
#     if ineq == "<":
#         if eq == "=":
#             if n <= m:
#                 answer += 1
#             else:
#                 answer += 0
#         elif eq == "!":
#             if n < m:
#                 answer += 1
#             else:
#                 answer += 0
            
#     elif ineq == ">":
#         if eq == "=": 
#             if n >= m:
#                 answer += 1
#             else:
#                 answer += 0
#         elif eq == "!":
#             if n > m:
#                 answer += 1
#             else:
#                 answer += 0
                
#     return answer
