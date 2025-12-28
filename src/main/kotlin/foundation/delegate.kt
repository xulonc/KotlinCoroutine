package foundation

import kotlin.properties.Delegates

/*
java 也可以有 委托，但会有很多模板代码
kotlin 使用 by 关键字来实现委托

委托方法

委托变量/属性

内置标准维多，比如 by lazy{}

Obserable也是委托

 */

fun main() {
    Manager().work()
    SeniorManager(CWorker()).work()
    val se = SeniorManager(JavaWorker())
    se.work()// 打印java work
    se.worker = CWorker() // 换了worker，
    se.work()// 但实际还是打印 java work ，没生效

    Uer().name = "alice"
}

//class Manager(val worker: Worker){ // 使用组合方式，传入实际的子类对象，然后调用
//    fun work(){
//        worker.work()
//    }
//}

// 换成 by 委托
// 实现了 worker接口中的方法， 实际是让 JavaWorker来实现的,也可以
// by 关键字左侧是 接口，右侧是实现
class Manager():Worker by JavaWorker(){
    // 内部会自动创建work方法，并路由到实际 实现，如 JavaWorker
}

// 带参数的woker，相比上面的更进一步
// 推荐使用val，而不是var
class SeniorManager(var worker: Worker):Worker by worker{
    // 对work()方法的调用，会自动传到worker实例中
    // 如果重写了 takeVacation ，会走重写的这个，而不会路由转发到worker
    override fun takeVacation() {
        TODO("Not yet implemented")
    }
}


// 也可以写两个构造参数，两个by委托




interface Worker{
    fun work()
    fun takeVacation()
}
class JavaWorker:Worker{
    override fun work() {
        println("java work")
    }

    override fun takeVacation() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return ("java tostring")
    }
}
class CWorker:Worker{
    override fun work() {
        println("c work")
    }

    override fun takeVacation() {
        TODO("Not yet implemented")
    }
}

class Uer{
    var name:String by Delegates.observable("default"){
        property, oldValue, newValue ->
        println("$property $oldValue $newValue")
    }
}