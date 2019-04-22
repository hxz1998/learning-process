# 导入整个模块 import pizza
# ~ pizza.make_pizza(12, '水果', '芝士')

# 导入模块中的特定函数
# ~ from pizza import make_pizza
# ~ make_pizza(12, '水果', '香蕉')

# 使用as重命名
# ~ import pizza as p
# ~ p.make_pizza(12, '水果')

# 导入所有函数
from pizza import *
make_pizza(12, '小李子')
