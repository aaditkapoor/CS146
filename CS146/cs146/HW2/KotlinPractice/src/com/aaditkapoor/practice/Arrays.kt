package com.aaditkapoor.practice

import java.util.Arrays

object Arrays {
    fun swapLargestAndSmallest(a: IntArray) { // we can first use the collections framework to get the min and max number from a.
        var index1 = 0 // smallest index
        var index2 = 0 // largest index
        var smallest = a[0]
        var largest = a[0]
        for (i in a.indices) {
            if (a[i] < smallest) {
                smallest = a[i]
                index1 = i
            }
            if (a[i] > largest) {
                largest = a[i]
                index2 = i
            }
        }
        // swapping the numbers.
        val temp = a[index2]
        a[index2] = a[index1]
        a[index1] = temp
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var a = intArrayOf(5, 4, 1, 9, 2, 6)
        swapLargestAndSmallest(a)
        println(Arrays.toString(a))
        println("Expected: [5, 4, 9, 1, 2, 6]")
        a = intArrayOf(1, 4, 1, 9, 2, 6)
        swapLargestAndSmallest(a)
        println(Arrays.toString(a))
        println("Expected: [9, 4, 1, 1, 2, 6]")
        a = intArrayOf(1, 4, 2, 9, 9, 6)
        swapLargestAndSmallest(a)
        println(Arrays.toString(a))
        println("Expected: [9, 4, 2, 1, 9, 6]")
        a = intArrayOf(1)
        swapLargestAndSmallest(a)
        println(Arrays.toString(a))
        println("Expected: [1]")
    }
}