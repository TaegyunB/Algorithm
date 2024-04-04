from sys import stdin

word = list(input())
word_list = []

for i in range(int(input())):
    a = stdin.readline().split()

    if a[0] == "L" and word: # and word: 각 해당 리스트가 비어 있지 않은 경우에만 조건이 참이 되도록 하는 역할
        word_list.append(word.pop())

    elif a[0] == "D" and word_list: # and word_list: 각 해당 리스트가 비어 있지 않은 경우에만 조건이 참이 되도록 하는 역할
        word.append(word_list.pop())

    elif a[0] == "B" and word:
        word.pop()

    elif a[0] == "P":
        word.append(a[1])

print("".join(word + word_list[::-1]))