fun main() {
    // задача: даны данные по выручке за недели в каждом месяце
    val data = mapOf(
        "Январь" to listOf(100, 100, 100, 100),
        "Февраль" to listOf(200, 200, -190, 200),
        "Март" to listOf(300, 180, 300, 100),
        "Апрель" to listOf(250, -250, 100, 300),
        "Май" to listOf(200, 100, 400, 300),
        "Июнь" to listOf(200, 100, 300, 300)
    )

    printInfo(data)
}

fun printInfo(data: Map<String, List<Int>>) {
    println("Средняя выручка в неделю: ${data.filter { it.value.all { it >= 0 } }.flatMap { it.value }.average()}")
    val sumRevenueOneMonth = data.filter { it.value.all { it >= 0 } }.map { it.value.sum() }
    println("Средняя выручка в месяц: ${sumRevenueOneMonth.average()}")
    val maxRevenueOneMonth = sumRevenueOneMonth.max()
    println("Максимальная выручка в месяц: $maxRevenueOneMonth")
    println("Была в следующих месяцах: ${
        data.filter { it.value.sum() == maxRevenueOneMonth && it.value.all { it >= 0 } }.map { it.key }
    }")
    val minRevenueOneMonth = sumRevenueOneMonth.min()
    println("Минимальная выручка в месяц: $minRevenueOneMonth")
    println("Была в следующих месяцах: ${
        data.filter { it.value.sum() == minRevenueOneMonth && it.value.all { it >= 0 } }.map { it.key }
    }")
    println("Ошибки произошли в следующих месяцах: ${data.filter { it.value.any { it < 0 } }.map { it.key }}")
}
