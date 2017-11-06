//
//  ViewController.swift
//  UITextXXXHideKeyboard
//
//  Created by 王军建 on 2017/11/6.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate, UITextViewDelegate {
    @IBOutlet weak var textField: UITextField!
    @IBOutlet weak var textView: UITextView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        textField.returnKeyType = .done
        textView.returnKeyType = .done
        
        textField.delegate = self
        textView.delegate = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        print(">>textFieldShouldReturn")
        
        textField.resignFirstResponder()
        return true
    }
    
    func textView(_ textView: UITextView, shouldChangeTextIn range: NSRange, replacementText text: String) -> Bool {
        if text == "\n" {
            print(">>textView")
            
            textView.resignFirstResponder()
            return true
        }

        return true
    }

}

