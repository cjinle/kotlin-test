package com.cjinle.utils

class TestBase {
    fun run() {
        _runData()
    }

    fun _runCase() {
        cases("Hello")
        cases(1)
        cases(0L)
        cases(MyClass())
        cases("hello")
    }

    fun _runLoops() {
        _for()
        _ranges()
        _eq()

        println(max(99, 10))
    }

    fun _runData() {
        val user = User("Alex", 1)
        println(user)

        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        println("user == secondUser: ${user == secondUser}")
        println("user == thirdUser: ${user == thirdUser}")

        // hashCode() function
        println(user.hashCode())
        println(secondUser.hashCode())
        println(thirdUser.hashCode())

        // copy() function
        println(user.copy())
        println(user === user.copy())
        println(user.copy("Max"))
        println(user.copy(id = 3))

        println("name = ${user.component1()}")
        println("id = ${user.component2()}")
    }

    fun cases(obj: Any) {
        when(obj) {
            1 -> println("One")
            "Hello" -> println("Greeting")
            is Long -> println("Long")
            !is String -> println("Not a string")
            else -> println("Unknown")
        }
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

class MyClass

data class User(val name: String, val id: Int) {
    override fun equals(other: Any?) =
        other is User && other.id == this.id
}