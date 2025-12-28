package foundation

val foo = { n: String -> println(n) } // 定义一个lambda表达式，并赋值

val bar = { n: String ->
    println(n)
    "hello"
} // lambda表达式 有多行方法体

fun show(name: String) = { n: String -> println(n) } // 定义一个函数，参数是name，返回值是一个lambda

fun order(name: String) = { n: String ->
    { println(n) }  // 定义一个函数，参数是name，返回值是一个lambda，{println(n)}是一个嵌套lambda，有两层lambda
    // 调用是需要多个括号()()
}

// 默认参数，命名参数
fun next(name: String, age: Int, married: Boolean = false, log: String = "$name $age $married") {

}


fun max(vararg nums: Int): Int { //可变参数vararg最好在参数末尾，和默认参数一样
    var large = Int.MIN_VALUE
    for (number in nums) {
        large = if (large > number) large else number
    }
    return large
}

fun main() {

    /*
    不能在lambda中 使用 return，但可以使用 带标签的return ，从当前lambda返回
     */


//    println(max(*intArrayOf(1, 2, 3, 3, 4))) // 展开可变参数
//
//    var doubleIt = { e: Int -> e * 2 }
//    println(doubleIt(2)) // 定义一个lambda，然后执行输入参数

    var factor = 2
    val doubled = listOf(1, 2).map { it * factor }
    val doubleAlso = sequenceOf(1, 2).map { it * factor }

    factor = 0

    doubled.forEach {
        println(it)
    }

    doubleAlso.forEach {
        println(it)
    }


}