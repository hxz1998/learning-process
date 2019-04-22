# Python学习项目

## 1. 起步
> Python 3.7.0 版本
1. Linux环境：
    * 编辑器：Geany
    * 运行展示：Terminal
    * 感觉：Linux系统环境比较合适编程，但是由于在虚拟机情况下性能并不是太好（不过并不妨碍学习）。另一方面，编辑器功能的局限性对于新手来说是个好事，
    并不妨碍学习的同时还能提前接触到各种错误。
2. Windows环境：
    * 编辑器：PyCharm Professional版本
    * 运行展示：IDE内置虚拟终端
    * 感觉：IDE功能强大，操作感觉上比较便捷，但是并不利于新手刚学习Python（太过强大的提示功能和自动补全功能导致有些错误被扼杀在了摇篮里）

## 2. 变量和数据类型
> 变量命名使用小写，下划线分割单词。（下划线命名风格）
1. Python中并不声明变量类型，直接变量名称就可以了。
2. 使用 `str()` 、 `int()` 、 `float()` 之类的方法来强制转换类型，防止出错。
3. 注释使用 `#` 标记

## 3. 列表
1. 在Python中列表使用 `[]` 来表示， 并用 `,` 号分割其中数据。
2. 增删改查列表内容：
    1. 增加：
        1. 末尾添加： `list_name.append(item)` 。
        2. 指定位置添加： `list_name.insert(index, item)` 。
    2. 删除：
        1. 指定位置删除： `del list_name[index]` 。
        2. 删除并弹出元素： `item_name = list_name.pop()` 或者 `item_name = list_name.pop(index)` 。
        3. 删除指定值： `list_name.remove(item)`
    3. 更改：
        1. 更改指定位置元素： `list_name[index] = item` 。
    4. 访问其中元素：
        1. 访问指定位置的元素： `list_name[index]` 。
        2. 访问最后一个元素： `list_name[-1]` 。           
3. 组织列表
    1. 使用 `sort()` 对列表永久排序。
    2. 使用 `sorted()` 对列表临时排序。
    3. 反转列表 `reverse()` 。
    4. 确定列表长度 `len(list_name)` 。
4. 使用 `range(start, end)` 创建数字列表
5. 简单统计计算
    1. `sum(list_name)` 求列表和。
    2. `max(list_name)` 求最大值。
    3. `min(list_name)` 求最小值。
6. 列表切片
    1. 知道起始位置和终止位置： `list_name[start:end]`
    2. 从起始位置到指定位置： `list_name[:end]`
    3. 从指定位置到末尾： `list_name[start:]`
    4. 获取最后一个元素： `list_name[-3:]` 获取最后三个元素
    5. 复制列表： `copy_list = list[:]`
7. 元组
    1. 在Python中使用 `()` 来表示元组， 元组就是不可变的列表， 如： `cell_name = (200, 50)` 。

## 4. `for` 循环
1. 一般用法：
    ```
    items = []
    for item in items:
        print(item)
    ```
2. 带指定次数的循环：
    ```
    # 循环四次， 输出 1， 2， 3， 4
    for value in range(1, 5):
        print(value)
    ```
3. 列表解析：
    ```
    # 生成一个1-10的平方列表
    squares = [value**2 for value in range(1, 11)]
    ```
    
## 5. `if` 语句
1. 用法：
    ```
    # if-else格式
    if statement:
        # 条件一
    else:
        # 默认条件
    
    # if-elif-else格式
    if statement:
        # 条件一
    elif statement:
        # 条件二
    else:
        # 默认条件
    ```
2. boolean表达式：
    1. True
    2. False
    3. （真别扭， 大写开头）

## 6. 字典
> 和Java中的Map类似， 使用键值对来关联索引和数据
1. Python中的字典使用 `{key:value, key:value, ...}` 来表示
2. 增删改查字典中的内容
    1. 增加
        1. `dict_name[new_key] = new_value`
    2. 删除
        1. `del dict_name[key]`
    3. 修改
        1. `dict_name[key] = new_value`
    4. 查找
        1. `dict_name[key]`
3. 结合 `for` 循环遍历字典
    ```
    # 循环遍历键-值
    for key, value in dict_name.items():
        print(str(key) + ':' + str(value))
    
    # 循环遍历键
    for key in dict_name.keys():
        print(str(key))
        
    # 循环遍历值
    for value in dict_name.values():
        print(str(value))
    ```
    * 可以使用 `set(dict_name)` 来创建一个没有重复内容的集合。
4. **好好利用列表和字典的嵌套~** 能够组成一个复杂的数据结构。

## 7. 用户输入和 `while` 循环
1. 用户输入：
    1. Python中使用 `input()` 函数完成对用户输入的读取和操作。例如： 
        ```
        name = input("请输入你的姓名：")
        print("hello, " + name)
        ```
2. `while` 循环：
    1. 用法：
        ```
        # 基本的用法
        while statement:
            # 条件符合时执行的内容
            
        # 使用标志位用法
        active = True
        while active:
            # 当active == True时执行的内容
        ```
    2. 使用 `break` 跳出循环。
    3. 使用 `continue` 来跳过本次循环。（其实与Java、 C、 C++、 JavaScript中功能一样）

## 8. 函数
1. 用法：
    > 声明函数 -> 调用函数。
    ```
    # 声明简单函数
    def func_name(params):
        # 函数体
    
    # 调用函数
    func_name(params)
    
    # 声明有返回值的函数
    def func_name(params):
        # 函数体
        return data
    
    # 调用有返回值的函数
    data = func_name(params)
    ```
2. Python中函数参数的那些事：
    1. 位置实参：根据函数声明中的位置来确定每个参数。在位置实参中顺序很重要。
    2. 关键字实参：根据声明的形参名称来确定实参位置。此时位置就没那么重要。如：
        ```
        # 声明
        func_name(param1, param2)
        
        # 调用
        func_name(param1=data1, param2=data2)
        ```
    3. 默认值：在函数声明时就给了参数的可能值。如：
        ```
        # 声明
        func_name(param1, param2=data)
        
        # 调用
        func_name(data1, data2)
        func_name(data1)
        func_name(param1=data1, param2=data2)
        ```
        * 这时候可以灵活应用使得参数成为可选的参数。
    4. 任意数量的实参：事先不知道需要多少参数，但是Python可以从调用函数中推算出参数的数量。如：
        ```
        # 声明
        def func_name(*params):
            for param in params:
                print(param)
            # 函数体
        ```
    5. 任意数量的关键字实参：接受一种键值对来完成参数的匹配，就是字典。如：
        ```
        # 声明
        def func_name(**params_map):
            for key, value in params_map:
                print(str(key) + str(value))
        ```
3. 将函数存储在模块中：
    1. 模块是扩展名为.py的文件。
        1. 例如文件名为 `file_name.py` 那么导入模块： `import file_name` 。
        2. 导入模块中的指定类： `from module_name import func_name_1, func_name_2` 。
        3. 导入模块后起别名： `from module_name import func_name as mf` 。
        4. 导入所有函数： `from module_name import *` 。
    2. 导入模块之后的后续操作：
        1. 使用模块中的方法： `module_name.func_name(params)` 。
        2. 使用别名之后的调用方法： `mf(params)` 。
  
## 9. 类
1. 类的声明：
    > 一定要写好 `__init__(self, params...)` 方法，方法中要带上 `self` 参数才能访问当前对象。
    ```
    class class_name(super_class_name):
        def __init__(self, params...):
            # 初始化方法
        def func_name(self, params...):
            # 自定义方法
    ```
2. 类的实例化：
    ```
    variable_name = class_name(init_params...)
    ```
3. 访问类的方法和属性
    > 和Java相同的 `.` 访问方式
4. 导入类
    ```
    from module_name import class_name
    ```
5. 类编码风格
    > 驼峰 + 下划线混合方式

## 10. 文件和异常
1. 打开文件并处理文件内容
    1. 打开方式： `w/r/a/r+` 四种方式。分别对应：写/读/追加/写并且读四种方式。
    2. 打开函数： Python中使用 `open(file_name) as obj_name` 来打开一个文件， 并作为一个文件对象 `obj_name` 。
    3. 写入文件内容：
        ```
        with open(file_name, 'w') as file_object:
            file_object.write(content)
        ```
    4. 读取内容然后按照行去处理：
        ```
        with open(file_name, 'r') as file_object:
            lines = file_object.readlines()
            for line in lines:
                print(line)
        ```
2. 异常
    > 就是try - catch - else代码块
    1. 示例：处理 `ZeroDivisionError` 异常：
        ```
        try:
            print(5/0)
        except ZeroDivisionError:
            print("您搞出了一个无限大数")
        ```
    2. 依赖 `try` 代码块正常执行的代码都应该放到 `else` 代码块中。
    3. `FileNotFoundError` 异常。
3. 读取解析 `json` 文件
    1. `json.dump(content, file_name)` , 将content内容json格式化之后写入file_name中。
    2. `json_object = json.load(file_object)` ，读取指定文件对象，并返回一个json对象。

---
时：2018年10月10日16点45分