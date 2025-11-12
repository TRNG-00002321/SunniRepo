def findDuplicate(arr):
    dictionary = {}
    for num in arr:
        if num in dictionary:
            return arr.index(num)
        else:
            dictionary[num] = 1

arr = [1, 5, 3, 4, 3, 5, 6]
print(findDuplicate(arr))
