bicycle = ['自行车', ' 破车', '有轮子的车', '没轮子的车', '山地车']
print(bicycle)

print(bicycle[0])
print(bicycle[-1])

bicycle.append('被添加的小车')
print(bicycle)
del bicycle[1]
print(bicycle)
bicycle[1] = bicycle[1] + str(666)
print(bicycle)

poped_bicycle = bicycle.pop()
print(poped_bicycle)
print(bicycle)

poped_bicycle_1 = bicycle.pop(1)
print(poped_bicycle_1)

bicycle.remove('没轮子的车')
print(bicycle)

bicycle_temp = ['ajdks', 'dureiw', 'bjdfks', 'zfjdsk', 'cfds']
bicycle_temp.sort()
print(bicycle_temp)
bicycle_temp.sort(reverse=True)
print(bicycle_temp)

bicycle_temp.reverse()
print(bicycle_temp)
print('列表长度' + str(len(bicycle_temp)))
