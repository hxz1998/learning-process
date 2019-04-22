import matplotlib.pyplot as plot

input_values = [1, 2, 3, 4, 5]
squares = [1, 4, 9, 16, 25]
plot.plot(input_values, squares, linewidth=5)

# 设置图表标题并给坐标轴加上坐标
plot.title("title", fontsize=24)
plot.xlabel("value", fontsize=14)
plot.ylabel("square of value", fontsize=14)

# 设置刻度标记大小
plot.tick_params(axis='both', labelsize=14)

plot.show()
