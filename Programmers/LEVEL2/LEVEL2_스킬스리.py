# -*- coding: utf-8 -*-
"""
Created on Thu Jun 22 01:22:42 2023

@author: twoo1
"""

def solution(skill, skill_trees):
    answer = 0
    arr = []
    skillList = []
    dic = {val : idx+1 for idx, val in enumerate(skill)}
    #print(dic)
    for sk in skill_trees:
        skList = str(sk)
        for ch in sk:
            if(not ch in skill):
                skList = skList.replace(ch, '')
        arr.append(skList)
    for i in arr:
        s = []
        for j in i:
            s.append(dic[j])
        skillList.append(s)
        
    for s in skillList:
        sortList = sorted(s)
        if(s == sortList):
            if(not s):
                answer +=1
            else:
                sumList = (max(s)+1)*max(s)//2 
                if(sumList == sum(sortList)):
                    answer +=1
            
    return answer



# def solution(skill, skill_trees):
#     answer = 0

#     for sk in skill_trees:
#         skillList = list(skill)
        
#         for s in sk:
#             if s in skillList:
#                 if s != skillList.pop(0):
#                     break;
#         else:
#             answer +=1
    


#     return answer