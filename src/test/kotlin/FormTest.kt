import org.junit.jupiter.api.Test

class FormTest {

    @Test
    fun main() {
        // Целочисленные типы
        val aByte: Byte = 0 // 8b   -128 + 127
        val aShort: Short = 0 // 16b -32768 +32767
        val aInt = 0 // 32b   (-2^32) .. (+2^32 -1)
        val intWrapper = 0
        val aLong = 0L // 64b
        // Типы с плавающей точкой
        val aFloat = 0.0f
        val aDouble = 0.0
        val doubleWrapper = 9.1
        // Символьный
        val aChar = 'a'
        val charWrapper = 'a'
        // Логически тип
        val aBoolean = true
        val booleanWrapper = true
        // Строка (и бесконечность других объектных/ссылочных типов)
        val toBePrint = "Hello world!"
        val teachers = mutableListOf<Int?>(10, 20)

        // Операторы
        // Оператор присвоения =
        val nameFirst = "Dmitrii"
        val age = 34
        val nameSecond = "Dmitrii"
        // Арифметические операторы + - / * % ++ --
        val result = aInt

        // Операторы сравнения <, >, >=, <=, !=, ==

        // Логические операторы &, |, &&, ||, !

//    System.out.println(!(nameFirst.equals("Dmitrii")));

        // Оператор instanceof
        //println(nameFirst is String)

        // Тернарный оператор
        val sex = 'm'

        // Управляющая конструкция if
        val a: String = if (sex == 'm') {
                "Valentin"
            } else if (sex == 'w') {
                "Valentina"
            } else {
                "(("
            }
        println(a)
        // ключевое слово new
        val name = "Dima"
    }


}
