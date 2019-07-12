@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    val x = age % 10.0
    if (age == 11) return "$age лет"
    if (age == 12) return "$age лет"
    if (age == 13) return "$age лет"
    if (age == 14) return "$age лет"
    if (age == 15) return "$age лет"
    if (age == 16) return "$age лет"
    if (age == 17) return "$age лет"
    if (age == 18) return "$age лет"
    if (age == 19) return "$age лет"
    if (age == 111) return "$age лет"
    if (age == 112) return "$age лет"
    if (age == 113) return "$age лет"
    if (age == 114) return "$age лет"
    if (age == 115) return "$age лет"
    if (age == 116) return "$age лет"
    if (age == 117) return "$age лет"
    if (age == 118) return "$age лет"
    if (age == 119) return "$age лет"
    if (x == 2.0) return "$age года"
    if (x == 3.0) return "$age года"
    if (x == 4.0) return "$age года"
    if (x == 0.0) return "$age лет"
    if (x == 5.0) return "$age лет"
    if (x == 6.0) return "$age лет"
    if (x == 7.0) return "$age лет"
    if (x == 8.0) return "$age лет"
    if (x == 9.0) return "$age лет"
    return "$age год"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val x1 = t1 * v1
    val x2 = t2 * v2
    val x3 = t3 * v3
    val x = (x1 + x2 + x3) / 2.0
    if (x1 >= x){
        val q = (x / v1)
        return q
    }
    val y = x1 + x2
    if (y >= x){
        val y1 = (x1 / v1)
        val y2 = ((x - x1) / v2)
        val y3 = y2 + y1
        return y3
    }
    val z3 = ((x - (x1 + x2)) / v3)
    val z4 = t1 + t2 + z3
    return z4
}
/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    if (kingX == rookX1 || kingY == rookY1 && kingX == rookX2 || kingY == rookY2) return 3
    if (kingX == rookX1 || kingY == rookY1) return 1
    if (kingX == rookX2 || kingY == rookY2) return 2
    return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    if (kingX == rookX || kingY == rookY && abs(kingX - bishopX) == abs(kingY - bishopY)) return 3
    if (abs(kingX - bishopX) == abs(kingY - bishopY)) return 2
    if (kingX == rookX || kingY == rookY) return 1
    return 0
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if (a >= b && a >= c && a + b > c && a + c > b && b + c > a) {
        val gip2 = a.pow(2)
        val kat2 = b.pow(2) + c.pow(2)
        if (gip2 > kat2) return 2
        if (gip2 == kat2) return 1
        return 0
    }
    if (b >= a && b >= c && a + b > c && a + c > b && b + c > a) {
        val gip2 = b.pow(2)
        val kat2 = a.pow(2) + c.pow(2)
        if (gip2 > kat2) return 2
        if (gip2 == kat2) return 1
        return 0
    }
    if (c >= a && c >= b && a + b > c && a + c > b && b + c > a) {
        val gip2 = c.pow(2)
        val kat2 = b.pow(2) + a.pow(2)
        if (gip2 > kat2) return 2
        if (gip2 == kat2) return 1
        return 0
    }
    return -1
}


/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (b >= a && d >=c) {
        if (a in c..d && b in c..d) {
            val x = b - a
            return x
        }
        if (a !in c..d && b in c..d) {
            val x = b - c
            return x
        }
        if (a in c..d && b !in c..d) {
            val x = d - a
            return x
        }
        if (c in a..b && d in a..b) {
            val x = d - c
            return x
        }
        if (c !in a..b && d in a..b) {
            val x = d - a
            return x
        }
        if (c in a..b && d !in a..b) {
            val x = b - c
            return x
        }
    }
    return -1
}
