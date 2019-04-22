import os
from pathlib import Path

# my_path = "S:/source"
#
# p = Path(my_path)
# for x in p.iterdir():
#     if x.is_dir():
#         print(str(x) + "是个目录")
#     elif x.is_file():
#         print(str(x) + "是个文件")


# p2 = Path()
# for x in p2.iterdir():
#     if x.is_file():
#         print(str(x) + "是一个文件")
#         if x.match("*.py"):
#             with x.open() as pp:
#                 print("--" + pp.readline())
#     elif x.is_dir():
#         print(str(x) + "是一个目录")


p = Path("../chapter16/")
for x in p.iterdir():
    if x.is_dir():
        print(str(x) + "是一个文件目录")
    elif x.is_file():
        print(str(x) + "是一个文件")
        if x.match("*.py"):
            st = x.stem
            with open("../chapter16/" + st + ".py", encoding="utf-8") as pp:
                # print(pp.read())
                for lin in pp.readlines():
                    print(lin.rstrip("\n"))


