with open('pi_digits.txt') as file_object:
	#读取全部内容，并且文件指针不会自动回来
	# ~ content = file_object.read()
	for line in file_object:
		print(line.rstrip())

with open('pi_digits.txt') as file_object:
	lines = file_object.readlines()

for line in lines:
	print(line.rstrip())

pi_string = ''
for line in lines:
	pi_string += line.strip()

print(pi_string)
print(len(pi_string))
111
file_name = 'pi_million_digits.txt'
with open(file_name) as file_object:
	lines = file_object.readlines()

pi_string = ''
for line in lines:
	pi_string += line.strip()

print(pi_string[:52] + "...")
print(len(pi_string))

my_birthday = '980224'
if my_birthday in pi_string:
	print("圆周率包含我的生日")
else:
	print("圆周率不包含我的生日")
