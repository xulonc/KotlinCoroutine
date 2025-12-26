open class Person {
    companion object Key {
        fun show(){
            println("Persson")
        }
    }

}
class Student:Person(){

}

fun main() {
    println(Person.Key.hashCode())
    println(Person.Key.hashCode())
}