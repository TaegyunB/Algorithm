# 간단한 코드
def solution(code):
    return "".join(code.split("1"))[::2] or "EMPTY"

# 내 코드
# def solution(code):
#     answer = ''
#     mode = 0
    
#     for i in range(len(code)):
#         if mode == 0:
#             if i % 2 == 0:
#                 if code[i] == "1":
#                     mode = 1
#                 else:
#                     answer += code[i]
#             else:
#                 if code[i] == "1":
#                     mode = 1
#                 else:
#                     continue
                    
#         elif mode == 1:
#             if i % 2 != 0:
#                 if code[i] == "1":
#                     mode = 0
#                 else:
#                     answer += code[i]
#             else:
#                 if code[i] == "1":
#                     mode = 0
#                 else:
#                     continue
                    
#     if len(answer) == 0:
#         answer = "EMPTY"

#     return answer
