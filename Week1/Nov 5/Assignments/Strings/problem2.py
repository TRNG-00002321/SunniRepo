def isPalindrome(s):
    return s == s[::-1]

s = "racecar"
print(isPalindrome(s))
s = "palindrome"
print(isPalindrome(s))
