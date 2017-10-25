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
        
        NoParamterAndNoReturn()
        
        callSetParamters()
        
        callGetPointerParamters()
      
        print(Add(10, 20))
    }

    private func callSetParamters() {
        let c: CChar = 127
        let uc: CUnsignedChar = 255
        let int16: CShort = -16
        let uint16: CUnsignedShort = 16
        let int32: CInt = -32
        let uint32: CUnsignedInt = 32
        let long32: CLong = -32
        let ulong32: CUnsignedLong = 32
        let long64: CLongLong = -64
        let ulong64: CUnsignedLongLong = 64
        let float32: CFloat = 32.32
        let float64: CDouble = 64.64
        let inStr = "Hello!"

        SetParamters(c, uc, int16, uint16, int32, uint32,
                     long32, ulong32, long64, ulong64,
                     float32, float64, inStr)
    }
    
    private func callGetPointerParamters() {
        var c: CChar = 0
        var uc: CUnsignedChar = 0
        var int16: CShort = 0
        var uint16: CUnsignedShort = 0
        var int32: CInt = 0
        var uint32: CUnsignedInt = 0
        var long32: CLong = 0
        var ulong32: CUnsignedLong = 0
        var long64: CLongLong = 0
        var ulong64: CUnsignedLongLong = 0
        var float32: CFloat = 0.0
        var float64: CDouble = 0.0

        let cPtr = UnsafeMutablePointer(&c)
        let ucPtr = UnsafeMutablePointer(&uc)
        let int16Ptr = UnsafeMutablePointer(&int16)
        let uint16Ptr = UnsafeMutablePointer(&uint16)
        let int32Ptr = UnsafeMutablePointer(&int32)
        let uint32Ptr = UnsafeMutablePointer(&uint32)
        let long32Ptr = UnsafeMutablePointer(&long32)
        let ulong32Ptr = UnsafeMutablePointer(&ulong32)
        let long64Ptr = UnsafeMutablePointer(&long64)
        let ulong64Ptr = UnsafeMutablePointer(&ulong64)
        let float32Ptr = UnsafeMutablePointer(&float32)
        let float64Ptr = UnsafeMutablePointer(&float64)
        
        let bufSize = 100
        let outStrPtr = UnsafeMutablePointer<Int8>.allocate(capacity: bufSize)  //分配内存
        
        GetPointerParamters(cPtr, ucPtr, int16Ptr, uint16Ptr, int32Ptr, uint32Ptr,
                            long32Ptr, ulong32Ptr, long64Ptr, ulong64Ptr,
                            float32Ptr, float64Ptr, outStrPtr)
        
        let outStr = String.init(cString: outStrPtr)
        outStrPtr.deallocate(capacity: bufSize)    //释放内存
        
        print("char \(c), unsigned char \(uc)\n",
            "short \(int16), unsigned short \(uint16)\n",
            "int \(int32), unsigned int \(uint32)\n",
            "long \(long32), unsigned long \(ulong32)\n",
            "long long \(long64), unsigned long long \(ulong64)\n",
            "float \(float32), double \(float64)\n",
            "out char* \(outStr)\n")
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

