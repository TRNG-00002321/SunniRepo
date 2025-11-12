def findSubstring(s, p):
    if p not in s:
        return -1
    
    return s.find(p)
    
s = "Hello"
p = "llo"
print(findSubstring(s, p))
