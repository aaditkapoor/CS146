package com.aaditkapoor.practice

import java.util.*

fun sortColors(list:Array<Int>) {
    var i = 0
    var j = 0
    for (k in 0 until list.size) {
        if (list[k] == 0) {
            list[k] = list[i].also { list[k] = list[i] }
            if (i < j) {
                list[k] = list[j].also {
                    list[j] = list[k]
                }
            }

            i+=1
            j+=1
        }
        else if (list[k] == 1) {
            list[k] = list[j].also { list[j] = list[k] }
            j+=1
        }
    }
}

fun main(args:Array<String>) {
    var x = arrayOf(2, 0, 2, 1, 1, 0)
    println(Arrays.toString(x))
    sortColors(x)
    println(Arrays.toString(x))
}

