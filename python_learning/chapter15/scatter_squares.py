import matplotlib.pyplot as plot

# 手工计算散点值
# x_value = [1, 2, 3, 4, 5]
# y_value = [1, 3, 6, 2, 10]
# plot.scatter(x_value, y_value, s=200)
# plot.show()

# 自动计算散点值
x_value = list(range(1, 1001))
y_value = [x ** 2 for x in x_value]

# 修改数据点颜色并删除数据点的轮廓
# plot.scatter(x_value, y_value, c='red', edgecolors='none')
# plot.scatter(x_value, y_value, c=(0, 0, 0), edgecolors='none')

# 使用颜色映射
plot.scatter(x_value, y_value, c=y_value, cmap=plot.cm.Blues, edgecolors='none')

# 自动保存图片，替换掉plot.show()
# plot.savefig('square_plot.png', bbox_inches='tight')
plot.show()
