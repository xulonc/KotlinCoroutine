package foundation

fun main() {
    val (first, second) = Pair("name", "alice") // Pari Triple data class 都可以解构
    println(first)

    val oneToFive = 1..5  // range范围
    val aToE = 'a'..'e'
    println(oneToFive.first)
    println(oneToFive.last)

    for (e in oneToFive) {
        println(e)
    }
    for (e in aToE) {
        println(e)
    }
    val next = 1 until 5 // 不包括
    for(e in next){
        println(e)
    }
    (1 .. 10 step 2) // 步进2
    (10 downTo 1 step 2)

    arrayOf("hello",1,2) //各种类型的数组
    intArrayOf(1,2,33) // 只能是整数的数组

    val name = "hello"
    println(name)
    println(name) // name.sout  tab 补全

    for((index,ele) in listOf("hello","world",23).withIndex()){
        println(index)
        println(ele)
    }

    fun whatToDo(dayOfWeek: Any) = when(dayOfWeek){ //表达式
        "Monday","Sunday"-> "relax"
        in listOf(1,2,3)->"number"
        is String ->"what?"
        else -> "default"
    }
    fun printWhatToDo(dayOfWeek: Any){ // 语句，执行不同逻辑
        when(dayOfWeek){
            "Monday","Sunday"-> "relax"
            in listOf(1,2,3)->"number"
            is String ->"what?"
            else -> "default"
        }
    }
    whatToDo("alice")

    fun systemInfo() = when(Runtime.getRuntime().availableProcessors()){
        1 -> "normal"
        in 2..16 -> "great"
        else -> "ultra"
    }
    println(systemInfo())
}