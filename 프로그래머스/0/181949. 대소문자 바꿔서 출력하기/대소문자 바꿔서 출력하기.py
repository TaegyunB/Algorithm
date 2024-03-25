str = input()
result = ""

for i in str:
    if i.islower():
        result += i.upper()
    elif i.isupper():
        result += i.lower()
        
print(result)