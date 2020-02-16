package com.caesar.cskoin.normal

/**
 * Created by Caesar
 * email : caesarshao@163.com
 */
class WeatherData(val normalData: NormalData) {
    fun printData(string: String) {
        normalData.printInfo(string)
    }
}