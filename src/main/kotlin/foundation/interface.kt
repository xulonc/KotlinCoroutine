package foundation


/*
interface 接口抽象程度最高，不能定义属性，但可以声明方法，实现方法，定义伴生对象
abstract 抽象类，可以定义属性

open类可以继承，final类不能继承

sealed class ,能够继承，但只能 有限继承，在同一个包类，有限制的继承，不能随意继承


 */

fun main() {
    println(Remote.name)
    println(Remote.show())
}

class TV{
    private var volume=0
    val remote:Remote
        get() { // 或等价 get()=TVRemote()
            return TVRemote() // java中的iterate()每次调用都返回新的迭代器，和这里类似
            //迭代器 是内部类
        }

    //定义inner class，才能方位外层的private volume
    inner class TVRemote:Remote{
        var volume = 20
        override fun up() {
            volume++// 就近访问volume，遮蔽效果
            println(this@TV.volume) // 外层类的volume
        }
    }

    class OtherRemote:Remote{
        override fun up() {
            // 这里不能访问volume ,这个是嵌套类
        }

    }
}

interface  Remote{
    // 接口中不能定义属性，抽象类可以
    //  val age:Int = 22
    fun up() // 方法声明

    fun down(){ // 方法实现
        println("down")
    }
    companion object{ // 伴生对象
        val name = "alice"
         fun show(){
             println("show")
         }
    }
}

abstract class Person{
    // 抽象类可以定义属性
    val name:String = "alice"
}

open class Vehicle(val year: Int,open var color:String){ // color可以被子类重写，但是year不可以
    open val km = 0
    final override fun toString(): String { // 子类不能重写
        return "year"
    }
    fun repaint(newColor:String){ // 方法隐藏是final，因此不能重写
        color = newColor
    }
}




