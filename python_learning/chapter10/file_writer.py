file_name = 'programming.txt'

# 打开文件的四种参数：w：写文件， r：读文件， a：追加文件， r+：能写能读
# 这种方式会清空原来文档内容
with open(file_name, 'w') as file_object:
	file_object.write('I love programming')
	file_object.write('我喜欢编程')

with open(file_name, 'a') as file_object:
	file_object.write('\n因为没事可做')
