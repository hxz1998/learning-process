import pygal

frequence = [155, 157, 197, 200, 333]
frequence2 = [155, 157, 197, 200, 333]

hist = pygal.Bar()

hist.title = "结果"
hist.x_labels = ['1', '2', '3', '4', '5']
hist.x_title = "横坐标"
hist.y_title = "纵坐标"

hist.add("D6", frequence)
hist.add("D7", frequence2)
hist.render_to_file("die_visual.svg")