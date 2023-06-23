

from collections import deque

def solution(numbers):  
    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            if(numbers[i] < numbers[j]):
                answer.append(numbers[j])
                break
        else:
            answer.append(-1)         
    return answer


answer = [-1]*len(numbers)
numIdx = []
for idx, val in enumerate(numbers):
    idxval = [idx, val]
    if(numIdx):
        while(numIdx and numIdx[-1][1] < val):
            answer[numIdx[-1][0]] = val
            numIdx.pop()                
    numIdx.append(idxval)
    