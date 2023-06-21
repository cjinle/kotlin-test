package com.cjinle.utils

class TestLoops {
    fun run() {
        _for()
        _ranges()
        _eq()

        println(max(99, 10))
    }

    fun _for() {
        val cakes = listOf<String>("carrot", "cheese", "chocolate")

        for (cake in cakes) {
            println("cake: $cake")
        }
    }

    fun _ranges() {
        for (i in 0..3) {
            print(i)
        }

        println()

        for (i in 0 until  3) {
            print(i)
        }

        println()

        for (i in 2..8 step 2) {
            print(i)
        }

        println()

        for (i in 3 downTo 0) {
            print(i)
        }

        println()

    }

    fun _eq() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")

        println(authors == writers)   // 1
        println(authors === writers)  // 2
    }

    fun max(a: Int, b: Int) = if (a > b) a else b

}