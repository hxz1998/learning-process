favorite_language = {
	'jen':'java',
	'ben':'C',
	'sarah':'python',
	'phil':'ruby',
	}
	
print(favorite_language['ben'] + '\n')

for key, value in favorite_language.items():
	print(key + ' --- ' + value)
	
for key, value in favorite_language.items():
	print('\nkey:' + key)
	print('\nvalue:' + value)

for key in favorite_language.keys():
	print('\n' + key.title())
	
friends = {
	'jen',
	'andy',
	'jim',
	}
for name in friends:
	if name in favorite_language:
		print(name + '你最喜欢的语言是：' + favorite_language[name])
	else:
		print(name + '你没有接受调查')
	

