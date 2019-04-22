import matplotlib.pyplot as plot


from random_walk import RandomWalk


# 创建一个随机漫步的实例， 并将其包含的点都绘制出来
rw = RandomWalk(50000)
rw.fill_walk()

# 修改窗口尺寸样式
plot.figure(dpi=128, figsize=(10, 6))

num_point = list(range(rw.num_point))
plot.scatter(rw.x_value, rw.y_value, c=num_point, cmap=plot.cm.Blues, edgecolors='none', s=1)

# 着重突出起点和终点
plot.scatter(0, 0, c='green', s=100)
plot.scatter(rw.x_value[-1], rw.y_value[-1], c='red', s=100)

# 隐藏坐标轴
plot.axis('off')

plot.show()
