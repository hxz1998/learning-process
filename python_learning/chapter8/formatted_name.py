def formatted_name(first_name, last_name, middle_name = ''):
	"""输出简洁的名字"""
	if middle_name:
		full_name = first_name + ' ' + middle_name + ' ' + last_name
	else:
		full_name = first_name + ' ' + last_name
	return full_name.title()
	
has_next = True
while has_next:
	first_name = input("请输入你的姓：")
	last_name = input("请输入你的名字：")
	full_name = formatted_name(first_name, last_name)
	print("您的姓名为：" + full_name + '\n')
	again = input("是否继续玩这个程序(Y/N)")
	if again == 'N':
		has_next = False
		print("拜拜～")

              
