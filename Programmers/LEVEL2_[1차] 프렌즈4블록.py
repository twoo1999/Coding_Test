# -*- coding: utf-8 -*-
"""
Created on Fri Jun 23 16:12:16 2023

@author: twoo1
"""

def solution(m, n, board):
    answer = 0
    b = []
    moveX = [0, 1, 0, 1]
    moveY = [0, 0, 1, 1]
    
    
    for i in range(n):
        col = []
        for j in range(m-1, -1, -1):
            col.append(board[j][i])
        b.append(col)
    while(1):
        point = []
        for i in range(m):
            for j in range(n):
                cha = []
                for x ,y in zip(moveX, moveY):
                    try:
                        if(ord('A') <=ord(b[j+y][i+x]) <= ord('Z')):
                            cha.append(b[j+y][i+x])
                    except:
                        cha.append(0)
                if(len(set(cha)) == 1 and not 0 in cha):
                    for x, y in zip(moveX, moveY):
                        point.append(m*(j+y) + (i+x))
        if(not point):
            break
        point = sorted(list(set(point)), reverse=True)
        answer += len(point)
        for i in point:
            b[i//m].pop(i%m)   

    return answer