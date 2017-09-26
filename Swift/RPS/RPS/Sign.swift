//
//  Sign.swift
//  RPS
//
//  Created by 王军建 on 2017/9/26.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import Foundation
import GameplayKit

enum Sign {
    case rock, paper, scissors
}

let randomChoice = GKRandomDistribution(lowestValue: 0, highestValue: 2)

func randomSign() -> Sign {
    let randomNum = randomChoice.nextInt()
    
    if randomNum == 0 {
        return .rock
    } else if randomNum == 1 {
        return .paper
    } else {
        return .scissors
    }
}
