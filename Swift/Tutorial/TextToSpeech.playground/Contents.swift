//: Playground - noun: a place where people can play

import UIKit
import AVFoundation

var text = "你好"

let utterance = AVSpeechUtterance(string: text)
utterance.rate = AVSpeechUtteranceDefaultSpeechRate
utterance.voice = AVSpeechSynthesisVoice(language: "zh-CN")

let av=AVSpeechSynthesizer()
av.speak(utterance)
