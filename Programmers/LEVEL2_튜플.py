def solution(s):
    answer = []
    str = s[1:-1]
    arr = []
    a = []
    for i in str:
        if(i == '{'):
            a = []
        elif(i == '}'):
            arr.append("".join(a))
        else:
            a.append(i)
    data = []
    for i in arr:
        data.append(list(map(int, i.split(','))))
    dic = {len(i): i for i in data}
    for i in range(1, len(dic) + 1):
        for j in dic[i]:
            if(not j in answer):
                answer.append(j)
    return answer