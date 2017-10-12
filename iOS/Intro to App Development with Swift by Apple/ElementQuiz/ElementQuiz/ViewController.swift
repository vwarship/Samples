//
//  ViewController.swift
//  ElementQuiz
//
//  Created by 王军建 on 2017/9/25.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var answerLabel: UILabel!
    
    let elementList = ["Carbon", "Gold", "Chlorine", "Sodium"]
    var currentElementIndex = 0

    override func viewDidLoad() {
        super.viewDidLoad()
        updateElement()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func showAnswer(_ sender: UIButton) {
        answerLabel.text = elementList[currentElementIndex]
    }
    
    @IBAction func gotoNextElement(_ sender: UIButton) {
        currentElementIndex += 1
        
        if currentElementIndex >= elementList.count {
            currentElementIndex = 1
        }
        
        updateElement()
    }
    
    func updateElement() {
        answerLabel.text = "?"
        
        let elementName = elementList[currentElementIndex]
        let image = UIImage(named: elementName)
        imageView.image = image
    }
    
}

