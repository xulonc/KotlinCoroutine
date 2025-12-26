import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.EmptyCoroutineContext

fun main() {
    runBlocking {
        val context = coroutineContext + CoroutineName("hello") + Dispatchers.IO
        println(context[CoroutineName])
        println(context[Job])
        println(context[ContinuationInterceptor]) // 获取Dispatcher，比如Dispatchers.IO ,等价 coroutineContext[CoroutineDispatcher]
        println(this)
        println("------")
        var scope = CoroutineScope(Job()) // 等价(CoroutineScope(EmptyCoroutineContext))，普通job，子协程异常会导致父协程也异常，最后也导致兄弟协程也取消
        scope=  CoroutineScope(SupervisorJob()) // 监督job，子协程异常，不会导致兄弟协程取消，父协程也能工作
        println(scope)

        println(EmptyCoroutineContext[CoroutineName]) // null
        println(EmptyCoroutineContext[Job]) // null
        println(EmptyCoroutineContext[ContinuationInterceptor]) // null

        MainScope().launch {// android环境才有 Dispatchers.Main ，此处报错
            println("....")
            delay(2000)
            println(".....")
        }
        with(scope) {
            println(this)
            launch {

            }
        }
        launch(context) {
            println(coroutineContext)
            println("launch 1")
        }
        launch {
            println(coroutineContext)
            println("launch 2")
        }
        println("end")
    }
}


