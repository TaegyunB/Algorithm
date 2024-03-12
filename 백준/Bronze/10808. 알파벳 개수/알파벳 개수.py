word = input()
word_count = []

alphabet = "abcdefghijklmnopqrstuvwxyz"

for i in alphabet:
    if i in word:
        word_count.append(word.count(i))
    else:
        word_count.append(0)
        
print(*word_count)