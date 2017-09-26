//
//  ViewController.swift
//  RPS
//
//  Created by 王军建 on 2017/9/26.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var playerButton: UIButton!
    @IBOutlet weak var stateLabel: UILabel!
    @IBOutlet weak var rockButton: UIButton!
    @IBOutlet weak var paperButton: UIButton!
    @IBOutlet weak var scissorsButton: UIButton!
    @IBOutlet weak var playAgainButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        startPlay()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func startPlay() {
        playAgainButton.isHidden = true
        rockButton.isHidden = false
        scissorsButton.isHidden = false
        stateLabel.text = "Rock, Paper, Scissors?"
        playerButton.titleLabel?.text = "🤖"
        rockButton.titleLabel?.text = "👊"
        paperButton.titleLabel?.text = "🖐"
        scissorsButton.titleLabel?.text = "✌️"
        
        paperButton.isEnabled = true
    }

    func play(sign: Sign) {
        let playerSign = randomSign()
        setPlayerSign(button: playerButton, sign: playerSign)
        setPlayerSign(button: paperButton, sign: sign)

        if sign == playerSign {
            stateLabel.text = "Draw"
        } else if (sign == .paper && playerSign == .rock) ||
            (sign == .rock && playerSign == .scissors) ||
            (sign == .scissors && playerSign == .paper) {
            stateLabel.text = "You Win"
        } else {
            stateLabel.text = "You Lose"
        }
        
        playAgainButton.isHidden = false
        rockButton.isHidden = true
        scissorsButton.isHidden = true
        
        playerButton.isEnabled = false
        paperButton.isEnabled = false
    }
    
    func setPlayerSign(button: UIButton, sign: Sign) {
        if sign == .rock {
            button.titleLabel?.text = "👊"
        } else if sign == .paper {
            button.titleLabel?.text = "🖐"
        } else if sign == .scissors {
            button.titleLabel?.text = "✌️"
        }
    }
    
    @IBAction func rockChoice(_ sender: Any) {
        play(sign:.rock)
    }
    
    @IBAction func paperChoice(_ sender: Any) {
        play(sign:.paper)
    }
    
    @IBAction func scissorsChoice(_ sender: Any) {
        play(sign:.scissors)
    }
    
    @IBAction func playAgain(_ sender: Any) {
        startPlay()
    }
    
}

