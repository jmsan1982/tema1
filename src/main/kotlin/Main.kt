fun main() {
    println("Hello World.")
    println("number of a's = " + countAs("Mary got married"))
    exercise2()
    assignReadersToBooks()
    printStringLength("This is a test")
    printStringLength(null)
    println("Concatenation: " + concatenate("hello", null))
    val numbers = exercise1()
    println(exercise3(53492722))
    exercise5()
}

// TODO: 1.- Write a function called exercise1()
// that prints the numbers from 1 to 10 with
// println() and invoke it from main().
// Look for how to make a “for” loop here:
// https://kotlinlang.org/docs/reference/control-flow.html

fun exercise1() {
    for (i in 1..10) {
        println("number: $i")
    }
}

// TODO: 2.- Uncomment this function:
fun exercise2() {
    var month = 1
    while (month != 0) {
        println("Enter the number of the month (0 to finish)")
        val monthStr = readLine()
        if (month > 0 && month <= 12) {
            month = monthStr!!.toInt() // Don't worry about the !! yet. We will study it later
            // TODO: 2 write the number of days that has that month, using the "when" structure
            // You can read about it here:
            // https://kotlinlang.org/docs/reference/control-flow.html
            // take into account that some months have 30, others 31 and one 28 or 29.
            // Invoke the function from main()
            when(month){
                0 -> print("")
                1 -> println("31 days")
                2 -> println("28 days")
                3 -> println("31 days")
                4 -> println("30 days")
                5 -> println("31 days")
                6 -> println("31 days")
                7 -> println("31 days")
                8 -> println("31 days")
                9 -> println("30 days")
                10 -> println("31 days")
                11 -> println("30 days")
                12 -> println("31 days")
                else -> println("not valid")
            }
        }
    }
}

// TODO: 3 Write a function called exercise3()
// that accepts a  number and returns a String
// that represents the corresponding NIF (number + letter)
// https://www.ordenacionjuego.es/en/calculo-digito-control
// https://kotlinlang.org/docs/reference/basic-types.html#arrays
fun exercise3(numberDni: Int): String {
    var resto: Int? = 0
    val letter = arrayOf(
        "t",
        "r",
        "w",
        "a",
        "g",
        "m",
        "y",
        "f",
        "p",
        "d",
        "x",
        "b",
        "n",
        "j",
        "z",
        "s",
        "q",
        "v",
        "h",
        "l",
        "c",
        "k",
        "e"
    )
    resto = numberDni % 23

    var response = "$numberDni - " + letter.get(resto)

    return response
}

// TODO: 4 Modify this function abbreviating it with "=" as return type
// (simplification 2)
// https://developer.android.com/kotlin/learn#simplifying
// Note: You can remove the : Int in the declaration

fun countAs(str: String): Int = str.count { c -> c == 'a' }


fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}

// TODO 5: Write a function called exercise5()
// In it you will invoke the function stringMapper declared above twice.
// The first one with a function that returns the number of characters
// and the second one with a function that returns the number of a’s.
// Print its results.
fun exercise5() {
    var stringLenght = stringMapper("android", { input ->
        input.length
    })

    var letterA = stringMapper("android", { input ->
        input.count { c -> c == 'a' }
    })

    return println("the total letters is: " + stringLenght + " number of a's = " + letterA)
}


data class Reader(val name: String, val age: Int)
data class Book(val title: String, var reader: Reader)
/*
Create a data class Book that has 2 parameters
title as a String that can not be modified (read only)
and reader as a Reader
*/
fun assignReadersToBooks() {
    val reader1 = Reader("John", 23)
    val reader2 = Reader("Mary", 34)
    val book1 = Book("The name of the wind", reader1)
    book1.reader = reader2
}

// TODO 7: Write the body of this function
// That prints the length of the string parameter.
// If the string is null, print 0
fun printStringLength(string: String?) {
    println("length = " + (string?.length ?: 0))
}

// TODO 8: Write a method concatenate() that concatenates 2 Strings
// received as parameters.
// If a String is null, convert it to “”.
// This is the invocation:
// println("Concatenation: " + concatenate("hello", null))


fun concatenate(strOne: String?, strTwo: String?):String {
    return (strOne ?: "") + (strTwo ?: "")
}