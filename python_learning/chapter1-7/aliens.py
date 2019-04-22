alien_0 = {'color':'green', 'point':5, 'speed':'medium'}
print(alien_0['color'])
print(alien_0)
alien_0['position_x'] = 5
alien_0['position_y'] = 0
print(str(alien_0) + '\n')

print('外星人是' + alien_0['color'] + '颜色的')
alien_0['color'] = 'yellow'
print('现在外星人是' + alien_0['color'] + '颜色的')

print('现在外星人在: x=' + str(alien_0['position_x']) + ', ' + str(alien_0['position_y']) + '处')
if alien_0['speed'] == 'slow': 
	alien_0['position_x'] = alien_0['position_x'] + 1
elif alien_0['speed'] == 'medium':
	alien_0['position_x'] = alien_0['position_x'] + 2
else:
	alien_0['position_x'] = alien_0['position_x'] + 3
print('现在外星人的位置是: (' + str(alien_0['position_x']) + ', ' + str(alien_0['position_y']) + ')')
	
del alien_0['color']
print(alien_0)
	
print('\n------我是分割线------')
aliens = []
for number in range(30):
	new_alien = {'color':'green', 'point':5, 'speed':'slow'}
	aliens.append(new_alien)
	
for alien in aliens[:5]:
	print(alien)
	
for alien in aliens[:3]:
	if alien['color'] == 'green':
		alien['color'] = 'yellow'
		alien['speed'] = 'medium'
	elif alien['color'] == 'yellow':
		alien['color'] = 'red'
		alien['speed'] = 'fast'

for alien in aliens[:10]:
	print(alien)
