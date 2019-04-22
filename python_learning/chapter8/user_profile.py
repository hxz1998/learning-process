def build_profile(first, last, **user_info):
	"""创建一个字典，其中包含所需的一切信息"""
	profile = {}
	profile['first_name'] = first
	profile['last_name'] = last
	for key, value in user_info.items():
		profile[key] = value
	return profile

profile = build_profile('hu', 'xiao', location='China', tell='123')
print(profile)

	
