//
//  ViewController.swift
//  UseOpenSSL
//
//  Created by 王军建 on 2017/10/25.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        let string = "Hello World!"
        let outStringLength = Int(MD5_DIGEST_LENGTH)
        let outStringPtr = UnsafeMutablePointer<UInt8>.allocate(capacity: outStringLength);
        
        MD5(string, outStringLength, outStringPtr)
        
        let md5 = NSMutableString()
        for i in 0..<outStringLength {
            md5.appendFormat("%02x", outStringPtr[i])
        }
        print(md5)
        
        outStringPtr.deallocate(capacity: outStringLength)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

}

