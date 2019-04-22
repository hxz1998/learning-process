"""
  Created by Xiaozhong on 2018/11/5.
  Copyright (c) 2018/11/5 Xiaozhong. All rights reserved.
"""

import sys
#
#
# arg = sys.argv[0]
# print("第一个参数是：" + str(arg))
#
# arg = sys.argv[1]
# print("第二个参数是：" + str(arg))

# 读取控制台参数，并且将其设置为字典数据格式
cmdss = {}
for index in range(1, len(sys.argv)):
    if index % 2 != 0:
        cmdss[sys.argv[index]] = sys.argv[index + 1]

print(cmdss)
