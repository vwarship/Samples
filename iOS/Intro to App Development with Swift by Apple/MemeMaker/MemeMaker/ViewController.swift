//
//  ViewController.swift
//  MemeMaker
//
//  Created by 王军建 on 2017/10/12.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var topCaptionSegmentedControl: UISegmentedControl!
    @IBOutlet weak var bottomCaptionSegmentedControl: UISegmentedControl!
    @IBOutlet weak var topCaptionLabel: UILabel!
    @IBOutlet weak var bottomCaptionLabel: UILabel!
    
    let topChoices = [CaptionChoice(emoji:"😎", text: "你知道怎样才够酷吗？"),
                      CaptionChoice(emoji:"👹", text: "你知道让我恼火的是什么吗？"),
                      CaptionChoice(emoji:"😘", text: "你知道我喜欢什么吗？")]
    
    let bottomChoices = [CaptionChoice(emoji:"🐱", text: "戴帽子的猫"),
                         CaptionChoice(emoji:"🐶", text: "运木头的狗"),
                         CaptionChoice(emoji:"🐵", text: "惊恐的猴子")]

    override func viewDidLoad() {
        super.viewDidLoad()
        setSegments(segmentedControl: topCaptionSegmentedControl, choices: topChoices)
        setSegments(segmentedControl: bottomCaptionSegmentedControl, choices: bottomChoices)
        topCaptionLabel.text = ""
        bottomCaptionLabel.text = ""
    }
    
    func setSegments(segmentedControl: UISegmentedControl, choices: [CaptionChoice]) {
        segmentedControl.removeAllSegments()
        for choice in choices {
            segmentedControl.insertSegment(withTitle: choice.emoji, at: segmentedControl.accessibilityElementCount(), animated: false)
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    @IBAction func topCaptionSegmentedControlValueChanged(_ sender: Any) {
        topCaptionLabel.text = topChoices[topCaptionSegmentedControl.selectedSegmentIndex].text
    }

    @IBAction func bottomCaptionSegmentedControlValueChanged(_ sender: Any) {
        bottomCaptionLabel.text = bottomChoices[bottomCaptionSegmentedControl.selectedSegmentIndex].text
    }

}

