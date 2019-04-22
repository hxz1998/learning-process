def make_pizza(size, *toppings):
	"""打印顾客的所有配料"""
	print("您要的尺寸是：" + str(size))
	print("您需要的材料有：")
	for topping in toppings:
		print('-' + str(topping))
