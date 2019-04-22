unprinted_designs = ['iphone', 'robot', 'tree']
completed_models = []

def print_models(unprinted_designs, completed_models):
	"""
	模拟打印，直到未打印列表中为空
	"""
	while unprinted_designs:
		current_model = unprinted_designs.pop()
		print("正在打印：" + current_model)
		completed_models.append(current_model)
	
def show_completed_model(completed_models):
	for model in completed_models:
		print("打印好的 : " + model)
		
print("原始状态" + str(unprinted_designs))
print("原始状态" + str(completed_models))
# print_models(unprinted_designs, completed_models) 这么调用会改变原来的值
print_models(unprinted_designs[:], completed_models)
show_completed_model(completed_models)
print("打印完之后状态" + str(unprinted_designs))
print("打印完之后状态" + str(completed_models))
