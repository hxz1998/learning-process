from random import choice


class RandomWalk:
    """一个生成随机漫步的类"""

    def __init__(self, num_point=5000):
        """初始化随机漫步的属性"""
        self.num_point = num_point

        # 所有随机漫步都起始于（0， 0）
        self.x_value = [0]
        self.y_value = [0]

    def fill_walk(self):
        """计算随机漫步的所有点"""

        # 不断漫步，直到点数符合要求
        while len(self.x_value) < self.num_point:
            x_direction = choice([-1, 1])
            x_distance = choice([0, 1, 2, 3, 4])
            x_step = x_direction * x_distance

            y_direction = choice([-1, 1])
            y_distance = choice([0, 1, 2, 3, 4])
            y_step = y_direction * y_distance

            if x_step == 0 and y_step == 0:
                continue

            next_x = self.x_value[-1] + x_step
            next_y = self.y_value[-1] + y_step

            self.x_value.append(next_x)
            self.y_value.append(next_y)
