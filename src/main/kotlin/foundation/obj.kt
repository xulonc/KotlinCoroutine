package foundation


// 定义单例
object Singleton {
    val name="alice"
}


fun main() {
    val person = object { // 直接声明一个对象表达式
        val name = "alice"
        val age = 22
        var married = false
    }
    println(person.name)

    println(Singleton.name)
    println(Singleton.hashCode())





    var obj = object : Runnable { // 生成一个匿名对象，并实现Runnable接口，匿名实例对象
        override fun run() {
            println("todo")
        }

    }

    val temp = Runnable {
        fun run() {
            println("todo")
        }
    }
    println(Util.cores().hashCode())
    println(Util.cores().hashCode())
    println(Car(2005, "red").color)


    //    Car(2005, "red").color = ""
    // Car(2005, "red").fuelLevel =122 // 这里会报错，因为private

    //每个全新的类实例，都共享同一个伴生对象
    MachineOperator("add").checkin()
    MachineOperator("add").checkin()
    MachineOperator("add").checkin()
    println(MachineOperator.checkedIn)
    MachineOperator("add").checkout()
    MachineOperator("add").checkout()
    println(MachineOperator.checkedIn)

    //如果直接打印类名，就相当于 打印伴生对象
    println(MachineOperator)
    println(MachineOperator.Companion) // 等价

    // 伴生对象，常用来表示共处方法

}

object Util { //单例
    fun cores() = Runtime.getRuntime().availableProcessors()
}


class Car(val yearOfMake: Int, theColor: String) {
    var fuelLevel = 100 //先写 属性
        private set // 写了set之后，类的外部，就无法赋值了

    // set方法正确写法 ，在写 set/get 方法
    // 可以在主构造函数中传入 theColor，也可以拿到对象后，单独赋值，触发set
//    var color:String="default" // var必须有个初始值，也就是get()
//        set(value) {
//            field = value
//        }

//    var color:String
//        get() = "default"  // 分别独立写  get 和 set
//        set(value) {
//            field = value
//        }

//    val name:String // 这种写法和下面等价
//        get() {
//            return  "alice"
//        }

    val name:String
        get() = "alice"


    var color = theColor //可以从构造函数中获取
        set(value) {
            if (value.isBlank()) {
                throw RuntimeException("异常")
            }
            field = value
        }

    //然后是 init 方法，只需要一个init即可
    init {
        println("init")
    }


    //二级构造函数，不能使用val/var，必须使用this
    constructor(fuelLevel: Int, yearOfMake: Int, theColor: String) : this(yearOfMake, theColor) {
        this.fuelLevel = fuelLevel
    }
    // 最后是各个成员方法

    fun show() {

    }
}
//类加载时，伴生对象实例会创建，此时每个类的实例，都共享这同一个伴生对象实例，类似java static关键字
class MachineOperator(val name: String) {

    fun checkin() = checkedIn++

    fun checkout() = checkedIn--

    companion object {
        var checkedIn = 0; // 多个实例共享此 可变的变量，因此可能存在线程安全问题
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}

class KotlinClass {
    companion object {
        // 使用 伴生对象，成为真正的静态方法。如果不这样写，java中就要明确添加 KotlinClass.Companion.sayHello();
        // 加了JvmStatic之后，就直接 KotlinClass.sayHello(); 能省略 Companion
        @JvmStatic
        fun sayHello() = println("Hello from Kotlin")

        @JvmStatic
        fun getVersion() = "1.0"

        const val VERSION = "1.0"  // const val 自动是静态的
    }
}


// 数据类
data class  Task(val id:String,val age:Int)


// 枚举类属性，自带name 和 ordinal 索引，Suit.values() 方法返回 name 和 ordinal
enum class Suit(val symbol:Char){
    CLUBS('\u2663'),// 没有重写的，使用公共 display方法
    DIAMONDS('\u2666'){ // 某一个枚举值，可重写方法
        override fun display(): String {
            return super.display()
        }
    };


    open fun display():String{
        return "$symbol $name"
    }


}

