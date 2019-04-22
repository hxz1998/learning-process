# 打印1-4的数
for value in range(1, 5):
	print(value)

numbers = list(range(1, 5))
print(numbers)
numbers = list(range(1, 11, 2))
print(numbers)

squares = []
for value in range(1, 11):
	squares.append(value**2)
print(squares)

print(max(squares))
print(min(squares))
print(sum(squares))

# 列表解析
squares = [values**2 for values in range(2, 20)]
print(str(squares) + '\n')

players = ['alice', 'charles', 'tom', 'jim', 'linus', 'force']
print(players[1:3])
print(players[:3])
print(players[1:])
print(players[-3:])
for player in players[1:3]:
	print(player.title())
