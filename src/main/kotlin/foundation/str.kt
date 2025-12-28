package foundation

fun main() {
    val str = """
        ================ 系统信息 ================
 主机名: DESKTOP-3MVDTN5
 系统: MINGW64_NT-10.0-19045
         内核版本: 3.4.10.x86_64
                架构: x86_64
     时间: Sat Dec 27 20:46:34 CST 2025
    """.trimIndent().lines().joinToString("\n") { it.trimStart() }
    println(str) // 格式化字符串



}