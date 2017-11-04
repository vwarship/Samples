//
//  HappinessViewController.swift
//  Happiness
//
//  Created by 王军建 on 2017/10/20.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class HappinessViewController: UIViewController, FaceViewDataSource {
    @IBOutlet weak var faceView: FaceView! {
        didSet {
            faceView.dataSource = self
        }
    }
    
    var smiliness: Double = 100 {
        didSet {
            smiliness = min(max(smiliness, 0), 100)
            updateUI()
        }
    }
    
    func updateUI() {
        faceView.setNeedsDisplay()
    }

    func smilinessForFaceView(sender: FaceView) -> Double? {
        return (smiliness-50)/50
    }

}
