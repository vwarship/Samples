//
//  FaceView.swift
//  Happiness
//
//  Created by 王军建 on 2017/10/20.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

@IBDesignable
class FaceView: UIView {

    @IBInspectable
    var lineWidth: CGFloat = 5 { didSet{ setNeedsDisplay() } }
    
    @IBInspectable
    var color: UIColor = UIColor.blue { didSet{ setNeedsDisplay() } }
    
    @IBInspectable
    var scale: CGFloat = 0.9 { didSet{ setNeedsDisplay() } }
    
    var faceCenter: CGPoint {
        return convert(center, from: superview)
    }
    var faceRadius: CGFloat {
        return min(bounds.size.width, bounds.size.height) / 2 * scale
    }
    
    override func draw(_ rect: CGRect) {
        let facePath = UIBezierPath(arcCenter: faceCenter, radius: faceRadius, startAngle: 0, endAngle: CGFloat(2*Double.pi), clockwise: true)
        facePath.lineWidth = lineWidth
        color.set()
        facePath.stroke()
    }

}
