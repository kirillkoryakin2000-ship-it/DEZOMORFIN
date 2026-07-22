package test.collections

import java.util.ArrayDeque
import java.util.LinkedList
import java.util.TreeSet


data class Person(val name: String, val age: Int)

class CarDequeExample {
    private val deque: ArrayDeque<String> = ArrayDeque()

    fun addElements(vararg elements: String) {
        for (element in elements) {
            deque.addLast(element)
        }
        println("Добавлены элементы: ${elements.joinToString(", ")}")
    }

    fun searchElement(element: String) {
        var found = false
        for (item in deque) {
            if (item == element) {
                found = true
                break
            }
        }
        println("Элемент $element найден: $found")
    }

    fun removeFirstElement() {
        if (deque.isNotEmpty()) {
            val removed = deque.removeFirst()
            println("Удалён первый элемент: $removed")
        } else {
            println("Deque пуст, нечего удалять")
        }
    }

    fun removeLastElement() {
        if (deque.isNotEmpty()) {
            val removed = deque.removeLast()
            println("Удалён последний элемент: $removed")
        } else {
            println("Deque пуст, нечего удалять")
        }
    }

    fun removeElement(element: String) {
        val removed = deque.remove(element)
        println("Элемент $element удалён: $removed")
    }
}

class LinkedListExample {
    private val numbers: LinkedList<Int> = LinkedList(listOf(657, 12, 55, 89, 203, 41))

    fun printElements() {
        println("Элементы списка: $numbers")
    }

    fun findElement(target: Int): Boolean {
        val iterator = numbers.iterator()
        var found = false
        while (iterator.hasNext()) {
            val current = iterator.next()
            if (current == target) {
                found = true
                break
            }
        }
        return found
    }

    fun removeElement(target: Int): Boolean {
        return numbers.remove(target)
    }

    fun countElements(): Int {
        return numbers.size
    }
}

class TreeSetExample {
    private val items: TreeSet<String> = TreeSet(listOf("AA", "BB", "CC"))

    fun printElements() {
        println("Элементы множества: $items")
    }

    fun findElement(element: String): Boolean {
        val list = items.toList()
        if (list.isEmpty()) return false
        var index = 0
        var found = false
        do {
            if (list[index] == element) {
                found = true
                break
            }
            index++
        } while (index < list.size)
        return found
    }

    fun removeElement(element: String): Boolean {
        return items.remove(element)
    }

    fun countElements(): Int {
        return items.size
    }
}

class HashMapExample {
    private val people: MutableMap<Int, Person> = hashMapOf(
        1 to Person("Alice", 30),
        2 to Person("Bob", 25),
        3 to Person("Charlie", 35)
    )

    fun addPerson(id: Int, person: Person) {
        people[id] = person
        println("Добавлен человек с ID $id: $person")
    }

    fun printAllPeople() {
        println("Все люди:")
        people.forEach { (id, person) ->
            println("ID $id -> $person")
        }
    }

    fun searchPerson(id: Int) {
        val person = people[id]
        if (person != null) {
            println("Человек с ID $id найден: $person")
        } else {
            println("Человек с ID $id не найден")
        }
    }

    fun removePerson(id: Int) {
        val removed = people.remove(id)
        if (removed != null) {
            println("Человек с ID $id удалён: $removed")
        } else {
            println("Человек с ID $id не найден, удаление невозможно")
        }
    }

}

fun main() {
    println("Класс, использующий Deque")
    val example = CarDequeExample()
    example.addElements("Toyota", "BMW", "Honda")
    example.searchElement("BMW")
    example.removeFirstElement()
    example.removeLastElement()
    example.removeElement("Honda")

    println("Класс, использующий List")
    val searchInt = LinkedListExample()
    searchInt.printElements()
    val searchElement = 657
    println("Element $searchElement found: ${searchInt.findElement(searchElement)}")
    val removeElement = 55
    println("Element $removeElement removed: ${searchInt.removeElement(removeElement)}")
    searchInt.printElements()
    println("Total number of elements: ${searchInt.countElements()}")

    println("Класс, использующий Set")
    val treeSet = TreeSetExample()
    println("Initial count of elements: ${treeSet.countElements()}")
    treeSet.printElements()
    val elementB = "BB"
    println("Element $elementB found: ${treeSet.findElement(elementB)}")
    val elementA = "AAA"
    println("Element $elementA removed: ${treeSet.removeElement(elementA)}")
    treeSet.printElements()
    println("Count after removal: ${treeSet.countElements()}")
    treeSet.removeElement("BB")
    treeSet.removeElement("CC")
    treeSet.printElements()
    println("Count after additional removals: ${treeSet.countElements()}")
    treeSet.removeElement("AA")
    treeSet.removeElement("CCC")
    treeSet.printElements()
    println("Final count of elements: ${treeSet.countElements()}")

    println("Класс, использующий Map")
    val person = HashMapExample()
    person.addPerson(4, Person("David", 28))
    person.addPerson(5, Person("Eve", 22))
    person.addPerson(6, Person("Frank", 33))
    person.printAllPeople()
    person.searchPerson(4)
    person.searchPerson(5)
    person.searchPerson(6)
    person.searchPerson(7) // Не существующий ID
    person.removePerson(2)
    person.removePerson(3)
    person.removePerson(7) // Не существующий ID
    person.printAllPeople()
    person.addPerson(7, Person("Grace", 40))
    person.addPerson(8, Person("Hank", 45))
    person.addPerson(9, Person("Ivy", 19))
    person.printAllPeople()
    person.searchPerson(7)
    person.searchPerson(8)
    person.searchPerson(9)
}
