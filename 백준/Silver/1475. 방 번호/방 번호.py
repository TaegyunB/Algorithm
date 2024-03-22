num_set = [0] * 10
num = input()

for i in num:
    if i == '6' or i == '9':
        if num_set[6] <= num_set[9]:
            num_set[6] += 1
        else:
            num_set[9] += 1
    else:
        num_set[int(i)] += 1
        
print(max(num_set))
        