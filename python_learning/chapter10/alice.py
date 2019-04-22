
def count_word(file_name):
	"""统计目标文件字符数"""
	try:
		with open(file_name, 'r') as file_object:
			contents = file_object.read()
	except FileNotFoundError:
		# 什么也不做
		# ~ pass
		print("文件没找到")
	else:
		words = contents.split()
		num_word = len(words)
		print(file_name + "这篇文章一共有:" + str(num_word) + "个字符")

count_word('alice.txt')
count_word('little_women.txt')
count_word('lalala.txt')
