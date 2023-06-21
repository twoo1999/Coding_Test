# -*- coding: utf-8 -*-
"""
Created on Wed Jun 21 15:50:58 2023

@author: twoo1
"""

def solution(dirs):
    # answer = 0
    # s = set()
    # dic = {'U' : (0, 1), 'D' : (0, -1), 'L' : (-1, 0), 'R' : (1, 0)}
    
    # x, y= 0, 0
    
    # for i in dirs:
    #     nx, ny = x + dic[i][0] , y + dic[i][1]
    #     if(-5<= nx <= 5 and -5 <= ny <= 5):
    #         s.add((x, y, nx, ny))
    #         s.add((nx, ny, x, y))
    #         x, y = nx, ny
    
    # return len(s) / 2
    
    start = [0, 0] #x, y
    route = []
    isSame = 0

    for i in dirs:
        isSame = 0
        if(i == 'U'):
            end = [start[0], start[1] + 1]
            if(end[1] > 5):
                end[1] = 5
        elif(i == 'L'):
            end = [start[0] -1, start[1]]
            if(end[0] < -5):
                end[0] = -5
        elif(i == 'R'):
            end = [start[0] + 1, start[1]]
            if(end[0] > 5):
                end[0] = 5
        elif(i == 'D'):
            end = [start[0], start[1] - 1]
            if(end[1] < -5):
                end[1] = -5
        if(not route):
            route.append([list(start), list(end)])
            answer += 1
        else:
            for r in route:
                if(start in r and end in r):
                    isSame = 1
                    break
            if(isSame == 0 ):
                route.append([list(start), list(end)])
                answer +=1
        start[0], start[1] = end[0], end[1]
        
            
    return answer