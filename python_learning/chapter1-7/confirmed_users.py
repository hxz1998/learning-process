unconfirmed_users = ['alice', 'brian', 'candace']
confirmed_users = []

while unconfirmed_users:
	user = unconfirmed_users.pop()
	print("正在验证的用户:" + user)
	confirmed_users.append(user)

print(unconfirmed_users)
print(confirmed_users) 
