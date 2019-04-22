class Dog():
	"""模拟小狗的简单尝试"""
	def __init__(self, name, age):
		self.name = name
		self.age = age

	def sit(self):
		"""模拟小狗坐下"""
		print(self.name + "坐下了")

	def roll_over(self):
		"""模拟小狗打滚"""
		print(self.name + "打滚")

my_dog = Dog('wille', 12)
print("我的小狗名字为:" + my_dog.name.title())
my_dog.sit()
my_dog.roll_over()
