"""一组用于描述Car的类"""

class Car():
	"""一次模拟汽车的行为"""

	def __init__(self, make, model, year):
		self.make = make
		self.model = model
		self.year = year

	def get_description_name(self):
		long_name = self.make + ' -- ' + self.model + ' -- ' + str(self.year)
		return long_name

# ~ my_car = Car('audi', 'a4', 2016)
# ~ print(my_car.get_description_name())

class Battery():
	"""模拟电池"""
	def __init__(self, battery_size=70):
		self.battery_size = battery_size

	def description_battery(self):
		print("这个电池容量是:" + str(self.battery_size))

class ElectricCar(Car):
	"""模拟继承关系"""

	def __init__(self, make, model, year):
		super().__init__(make, model, year)
		self.battery = Battery()

# ~ my_electric_car = ElectricCar('tesla', 's', 2016)
# ~ print(my_electric_car.get_description_name())
# ~ my_electric_car.battery.description_battery()
