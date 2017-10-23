//
//  ViewController.swift
//  SwiftCallC
//
//  Created by 王军建 on 2017/10/23.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var xTextField: UITextField!
    @IBOutlet weak var yTextField: UITextField!
    @IBOutlet weak var resultTextField: UITextField!
    
    var x: CInt {
        return CInt(xTextField.text ?? "0")!
    }
    
    var y: CInt {
        return CInt(yTextField.text ?? "0")!
    }
    
    var result: CInt {
        get {
            return CInt(resultTextField.text ?? "0")!
        }
        set {
            resultTextField.text = String(newValue)
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    @IBAction func add(_ sender: UIButton) {
        let expression = sender.currentTitle!
        
        switch expression {
        case "+":
            result = c_add(x, y)
        case "−":
            result = c_sub(x, y)
        default:
            break
        }
    }
    
}

