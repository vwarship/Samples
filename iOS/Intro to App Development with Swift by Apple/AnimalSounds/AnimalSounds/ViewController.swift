//
//  ViewController.swift
//  AnimalSounds
//
//  Created by 王军建 on 2017/9/25.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {

    @IBOutlet weak var animalSoundLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func playSound(name: String) {
        let music = Bundle.main.path(forResource: name, ofType: "mp3")
        let audioPlayer = try! AVAudioPlayer(contentsOf: URL(fileURLWithPath: music! ))
        audioPlayer.play()
    }

    @IBAction func catButtonTapped(_ sender: Any) {
        animalSoundLabel.text = "Meow!"
    }
    
    @IBAction func dogButtonTapped(_ sender: Any) {
        animalSoundLabel.text = "Woof!"
    }
    
    @IBAction func cowButtonTapped(_ sender: Any) {
        animalSoundLabel.text = "Moo!"
    }
    
}
