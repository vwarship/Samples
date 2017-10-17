//: Playground - noun: a place where people can play

import UIKit

var ss = ["a", "b", "c"]
print(ss)

ss.append("d")

var ss2 = [String]()

ss2.append("1")
ss2.append("2")

ss.remove(at: 1)
ss.first
ss.last

print(ss)


var str = "Hello worldāáăà"

for s in str {
    print(s)
}
print(str.count)

str.dropLast()
print(str)


