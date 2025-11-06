def nonNegativeAverage(arr):
    newarr = [x for x in arr if x > 0]
    sum = 0
    for num in newarr:
        sum += num
    return sum/len(newarr)

arr = [-12, 8, -7, 6, 12, -9, 14]
print(nonNegativeAverage(arr))
