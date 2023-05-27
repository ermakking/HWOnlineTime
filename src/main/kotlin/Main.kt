fun main() {
    val secondsAgo = 0
    if (secondsAgo >= 0) agoToText(secondsAgo) else println("Количество секунд не может быть отрицательным")
}

fun agoToText(secondsAgo: Int) {

    val min = (secondsAgo / 60).toDouble()
    val hour = secondsAgo / 60 / 60
    when (secondsAgo) {
        in 0..60 -> println("был(а) только что")
        in 61..60 * 60 - 1 -> println("был(а) в сети " + min.toInt() + " минут" + endingMin(min) + " назад")

        in 60 * 60..24 * 60 * 60 - 1 -> println("был(а) в сети " + hour + " час" + endingHour(hour) + " назад")

        in 24 * 60 * 60..24 * 60 * 60 * 2 - 1 -> println("был(а) в сети вчера")
        in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 - 1 -> println("был(а) в сети позавчера")
        else -> println("был(а) в сети давно")
    }
}

fun endingMin(min: Double): String {
    return when (min % 10) {
        0.1, 1.0 -> "у"
        0.2, 0.3, 0.4, 2.0, 3.0, 4.0 -> "ы"
        else -> ""
    }
}

fun endingHour(hour: Int): String {
    return when (hour) {
        1, 21 -> ""
        2, 3, 4, 22, 23, 24 -> "а"
        else -> "ов"
    }
}