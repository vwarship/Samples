//
//  ViewController.swift
//  UIImageView
//
//  Created by 王军建 on 2017/10/12.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var imageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imageView.image = #imageLiteral(resourceName: "菜问")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func switchImage(_ sender: UIButton) {
        let text = sender.currentTitle!
        
        switch (text) {
        case "菜问": imageView.image = #imageLiteral(resourceName: "菜问")
        case "普通僵尸": imageView.image = #imageLiteral(resourceName: "普通僵尸")
        case "海盗船长僵尸": imageView.image = #imageLiteral(resourceName: "海盗船长僵尸")
        default: imageView.image = #imageLiteral(resourceName: "菜问")
        }
    }
    
}

