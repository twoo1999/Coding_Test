def solution(maps):
    answer = 0
    mapYLen = len(maps)
    mapXLen = len(maps[0])
    route = [[0 for i in range(mapXLen)] for j in range(mapYLen)]
    
    movex = [0, 0, 1, -1]
    movey = [1, -1, 0, 0]
    start = [0, 0] # y, x
    queue = []
    queue.append(start)
    route[0][0] = 1
    while queue:
        point = queue.pop(0)
        cnt = route[point[0]][point[1]]+1
        for i in range(4):
            movepoint = [point[0], point[1]]
            movepoint[0] += movey[i]
            movepoint[1] += movex[i]
            if(movepoint[0] >= 0 and movepoint[0] < mapYLen and movepoint[1] >= 0 and movepoint[1] < mapXLen):
                if maps[movepoint[0]][movepoint[1]] == 1 and route[movepoint[0]][movepoint[1]] == 0: #   
                    route[movepoint[0]][movepoint[1]] = cnt
                    queue.append(movepoint)
                                      
    
    answer = -1 if route[mapYLen-1][mapXLen-1] == 0 else route[mapYLen-1][mapXLen-1] 
    

    
    
    return answer