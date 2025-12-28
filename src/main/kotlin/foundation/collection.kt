package foundation


fun main() {
    val result = listOf("hello",1,false) // 可变参数，参数类似变化，底层来自java 的Arrays.asList()
    println(result.javaClass) // 打印的 java.util.Arrays$ArrayList，数组包装类，不能添加元素

    val arr = arrayOf("hello",1,false) // 数组，,里面是object [Ljava.lang.Object，不能添加元素
    println(arr.javaClass)

    val foo = intArrayOf(1,2,3) //只能是整数

    var temp = mutableListOf("hello",2,false) // 标准的动态数组，可以添加元素
    println(temp.javaClass)  // 打印class java.util.ArrayList
    println(arrayListOf("hello",1,false).javaClass) // 也是 class java.util.ArrayList,底层一定是 ArrayList
    // 但mutableListOf 底层目前也是ArrayList，但是可以变的，优先使用mutableListof

    println(Pair("hello","world")) //等价
    println("hello" to "world")

    println(mapOf("name" to "alice","age" to 22)) // 创建map

    println(mapOf("name" to "alice", "age" to 22).javaClass) // class java.util.LinkedHashMap，和list有区别。
    // 这里底层是一样，只是封装表现不一样，读写。 这个时候要注意线程安全，比较不可写的才安全些
    println(mutableMapOf("name" to "alice","age" to 22).javaClass) // class java.util.LinkedHashMap

    // java中对象数组，可以存放子类型
    // Object[] mixed = new Object[4];

    var airportCodes = listOf("LAX","SFO","PDX","SEA")
    airportCodes.map {
        it to it.hashCode()
    }.also {
        println(it)
        println("${it.first().first} ${it.last().second}") // fist() last()指的是list中的开始和最后一个元素
        // first second 指的是 提取 pair 元素
    } // 还是在listof里面

    println(Triple("name","alice",22)) // triple 多了个 third，相比 pair
    // 如果是需要更多的元素，就使用 data class 数据类

    // 优先使用其他集合 如list，只有特殊底层，优化需要时才使用arrayOf
    val friends = arrayOf("alice","bob","tony")
    println(friends.javaClass)// class [Ljava.lang.String;
    println(arrayOf("hello", false).javaClass)// 有其他元素时，就是object ，class [Ljava.lang.Object;

    // 还有其他简便方法,下面这些没有 拆箱封箱动作，优化
    println(intArrayOf(1,2,3).javaClass) // 打印 整型数组 class [I
    // byteArrayOf ,charArrayOf 等等，基础整型类型，但没有string
    println(byteArrayOf(1,2,3).javaClass)  // class [B


    println(setOf("hello",2,false).javaClass) // class java.util.LinkedHashSet


    println(mapOf("name" to "alice","age" to 22).javaClass) // class java.util.LinkedHashMap
    //同理还有这些方法 hashMapOf() 对应 HashMap 底层数据结构
    // linkedMapOf()  LinkedHashMap
    // sortedMapOf()  SortedMap
    for (ele in mapOf("name" to "alice","age" to 22)){
        println(ele.key)
        println(ele.value)
    }


}
