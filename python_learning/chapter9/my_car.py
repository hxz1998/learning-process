# 导入模块中的类
# ~ from Car import Car, ElectricCar

# ~ my_new_car = Car('audi', 'a6', 2016)
# ~ print(my_new_car.get_description_name())

# ~ my_new_electric_car = ElectricCar('telsa', 's', 2016)
# ~ print(my_new_electric_car.get_description_name())
# ~ my_new_electric_car.battery.description_battery()

# 导入整个模块
import Car
my_new_car = Car.Car('audi', 'a6', 2016)
print(my_new_car.get_description_name())

my_new_electric_car = Car.ElectricCar('telsa', 's', 2016)
print(my_new_electric_car.get_description_name())
my_new_electric_car.battery.description_battery()
