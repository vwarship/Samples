//
//  ViewController.swift
//  UserDefaults
//
//  Created by 王军建 on 2017/10/17.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var ageTextField: UITextField!
    
    let keyUsername = "username"
    let keyAge = "age"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        if let username = UserDefaults.standard.string(forKey: keyUsername) {
            usernameTextField.text = username
        }
        
        if let age = UserDefaults.standard.string(forKey: keyAge) {
            ageTextField.text = age
        }
        
        print("abc ", UserDefaults.standard.integer(forKey: "ABC"))
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    @IBAction func saveButton(_ sender: UIButton) {
        if let username = usernameTextField.text {
            UserDefaults.standard.set(username, forKey: keyUsername)
        }
        
        if let age = ageTextField.text {
            UserDefaults.standard.set(age, forKey: keyAge)
        }
    }

}

