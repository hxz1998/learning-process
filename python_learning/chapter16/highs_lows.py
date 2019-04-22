import csv
from matplotlib import pyplot as plot
from datetime import datetime

# 天气数据1
# file_name = 'sitka_weather_2014.csv'
file_name = 'death_valley_2014.csv'

with open(file_name) as f:
    reader = csv.reader(f)
    header_row = next(reader)

    # 按照序列打印表头
    # for index, column_header in enumerate(header_row):
    #     print(index, column_header)

    dates, lows, highs = [], [], []
    for row in reader:
        try:
            current_date = datetime.strptime(row[0], "%Y-%m-%d")
            high = int(row[1])
            low = int(row[3])
        except ValueError:
            print(str(current_date), "数据不完整")
        else:
            dates.append(current_date)
            highs.append(high)
            lows.append(low)

    plot.plot(dates, highs, c='red')
    plot.plot(dates, lows, c='blue')
    plot.fill_between(dates, lows, highs, facecolor='blue', alpha=0.1)
    plot.show()