//
//  CircleView.swift
//  CircleView
//
//  Created by 王军建 on 2017/10/20.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

@IBDesignable
class CircleView: UIView {

    @IBInspectable
    var lineWidth: CGFloat = 5 { didSet { setNeedsDisplay() } }
    
    @IBInspectable
    var color: UIColor = UIColor.red { didSet { setNeedsDisplay() } }
    
    @IBInspectable
    var scale: CGFloat = 0.9 { didSet { setNeedsDisplay() } }
    
    var circleCenter: CGPoint {
        return convert(center, from: superview)
    }
    var radius: CGFloat {
        return min(bounds.size.width, bounds.size.height) / 2 * scale
    }
    
    override func draw(_ rect: CGRect) {
        let circle = UIBezierPath(arcCenter: circleCenter, radius: radius,
                                  startAngle: 0, endAngle: CGFloat(2*Double.pi), clockwise: true)
        color.set()
        circle.fill()
        circle.stroke()
    }

}
