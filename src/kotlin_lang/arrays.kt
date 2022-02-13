package kotlin_lang

fun main() {
    filterIsInstance()
}

/**
 * @see _ArraysJvm.kt
 * public fun <R> Array<*>.filterIsInstance(klass: Class<R>): List<R>
 *
 * @see _Arrays.kt
 * public inline fun <reified R> Array<*>.filterIsInstance(): List<@kotlin.internal.NoInfer R>
 *
 * Rough yet inaccurate takeaway:
 * 1. `Int?` @ Kotlin == `Integer` @ Java, while `Int` @ Kotlin == `int` @ java
 * 2. `Int` derives from `Number` as a Kotlin class, yet interops with `Integer` as a Java class
 */
private fun filterIsInstance() {
    val objects = arrayOf(123, "str", 3.1415f, null)

    val incorrectJava = objects.filterIsInstance(Int::class.java)   // or Int.javaClass
    val correctJava = objects.filterIsInstance(Integer::class.java)
    val correctKotlin = objects.filterIsInstance<Int>()

    println("java incorrect: $incorrectJava")
    println("java correct: $correctJava")
    println("kotlin correct: $correctKotlin")

    println()

    val i: Any = 123
    println("java incorrect under the hood: " + Int.javaClass.isInstance(123))
    println("java correct under the hood: " + Integer::class.java.isInstance(123))
    println("kotlin under the hood: " + (123 is Int))
    println("kotlin's syntax sugar': " + (i is Integer))
}