package foundation

fun main() {

    // try-catch 也有返回值，如果没有异常就是try的返回值，如果有异常，就是catch块返回值
   try {
        Thread.sleep(1000)
        "hello"
        1 / 0
    } catch (e: Exception) {
        e.printStackTrace(System.err)
        e.stackTraceToString()
    } finally {
        println("finally") // 无论如何都会执行
    }.let { println(it) }
}