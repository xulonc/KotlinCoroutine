package foundation

fun main() {
    val name: String? = null
    println(name?.hashCode())
    println(name?.hashCode() ?: "default hashcode")// 如果为null，就使用?:默认值

    // !! 类型断言，强制不检查是否null，不为null正常运行，如果为null，就空指针异常

    // when 也可以代替 猫王运算符
    val result = when(name){
        "alice" -> "bob"
        null -> "null"
        else -> "else"
    }

    val age:Int? = null
    val ageOther:String? = age as? String // 如果确实能转换就转，无法转的就会变成null，所以是安全转换运算符


}

fun foo(name:Any)=when(name){
    is String ->"str" // when 搭配Any ，可以使用is 判断类型
    else -> "default"
}

fun divide(n: Int): Int { // 返回类型是Int，也能接受Nothing
    if (n != 0) {
        return 10 / n // 正常返回int
    } else {
        throw RuntimeException("by zero") // nothing，其实就是不返回，报了异常，
    }
}

fun foo() { // 返回类型是Unit
    println("hello")
}