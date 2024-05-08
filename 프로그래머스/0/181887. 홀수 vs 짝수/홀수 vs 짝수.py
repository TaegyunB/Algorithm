def solution(num_list):
    
# 내 풀이
#     even = 0
#     odd = 0
    
#     for i in range(len(num_list)):
#         if i % 2 != 0:
#             even += num_list[i]
#         else:
#             odd += num_list[i]
            
#     if even < odd:
#         return odd
#     else:
#         return even

# 간단한 풀이
    return max(sum(num_list[::2]), sum(num_list[1::2]))