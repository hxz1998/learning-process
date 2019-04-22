class Settings():
	"""存储整个游戏相关的设置"""
	def __init__(self):
		self.screen_width = 1200
		self.screen_height = 800
		self.bg_color = (230, 230, 230)

		# 飞船设置
		self.ship_speed_factor = 1.5
		self.ship_limit = 3
		
		# 子弹设置
		self.bullet_speed_factor = 3
		self.bullet_width = 3
		self.bullet_height = 15
		self.bullet_color = (60, 60, 60)
		self.bullet_allow = 3

		# 外星人设置
		self.alien_speed_factor = 1
		self.fleet_drop_speed = 10
		# fleet_direction 为1时向右移动，为-1时向左移动
		self.fleet_direction = 1