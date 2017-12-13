import sys

class Solution:
    def withoutConsectiveZeroes(self, n):

        endWithZero = [0] * (n + 1)
        endWithOne = [0] * (n + 1)

        endWithZero[1] = 1
        endWithOne[1] = 1

        for i in range(2, n + 1):
            endWithZero[i] = endWithZero[i-1] + endWithOne[i-1]
            endWithOne[i] = endWithZero[i-1]

        return endWithZero[n] + endWithOne[n]


t = int(input())
if (t < 1 or t >= 10**3):
    sys.exit("Number of Test Cases should be less 1000")


for number in range(t):
    mod = 10**9 + 7
    result = []

    n = int(input())
    if (n < 1 or n >= 10**15):
        sys.exit("Number of binary digits should be less than 10000")
    
    result = Solution().withoutConsectiveZeroes(n) % mod
    print(result)
