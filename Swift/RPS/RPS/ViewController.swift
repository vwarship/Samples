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
        stateLabel.text = NSLocalizedString("GAME_START_TEXT", comment: "")
        playerButton.titleLabel?.text = "🤖"
        playerButton.setTitle("🤖", for: UIControlState.normal)
        rockButton.titleLabel?.text = "👊"
        rockButton.setTitle("👊", for: UIControlState.normal)
        paperButton.titleLabel?.text = "🖐"
        paperButton.setTitle("🖐", for: UIControlState.normal)
        scissorsButton.titleLabel?.text = "✌️"
        scissorsButton.setTitle("✌️", for: UIControlState.normal)
        
        paperButton.isEnabled = true
    }

    func play(sign: Sign) {
        let playerSign = randomSign()
        setPlayerSign(button: playerButton, sign: playerSign)
        setPlayerSign(button: paperButton, sign: sign)

        if sign == playerSign {
            stateLabel.text = NSLocalizedString("GAME_STATE_DRAW", comment: "")
        } else if (sign == .paper && playerSign == .rock) ||
            (sign == .rock && playerSign == .scissors) ||
            (sign == .scissors && playerSign == .paper) {
            stateLabel.text = NSLocalizedString("GAME_STATE_WIN", comment: "")
        } else {
            stateLabel.text = NSLocalizedString("GAME_STATE_LOSE", comment: "")
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
            button.setTitle("👊", for: UIControlState.normal)
        } else if sign == .paper {
            button.titleLabel?.text = "🖐"
            button.setTitle("🖐", for: UIControlState.normal)
        } else if sign == .scissors {
            button.titleLabel?.text = "✌️"
            button.setTitle("✌️", for: UIControlState.normal)
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

