//
//  ViewController.swift
//  CustomUI
//
//  Created by 王军建 on 2017/10/16.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let button = Bundle.main.loadNibNamed("MyButton", owner: self)?.first as! UIButton
        self.view.addSubview(button)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }


}

