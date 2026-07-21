package test.collections

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class CarDequeExampleTest {

    private lateinit var example: CarDequeExample

    @BeforeEach
    fun setUp() {
        example = CarDequeExample()
    }

    @Test
    fun `addElements не выбрасывает исключений при добавлении`() {
        assertDoesNotThrow {
            example.addElements("Toyota", "BMW", "Honda")
        }
    }

    @Test
    fun `removeFirstElement не выбрасывает исключений на пустом deque`() {
        assertDoesNotThrow {
            example.removeFirstElement()
        }
    }

    @Test
    fun `removeLastElement не выбрасывает исключений на пустом deque`() {
        assertDoesNotThrow {
            example.removeLastElement()
        }
    }

    @Test
    fun `removeElement отсутствующего элемента не выбрасывает исключений`() {
        example.addElements("Toyota")
        assertDoesNotThrow {
            example.removeElement("BMW")
        }
    }
}

class LinkedListExampleTest {

    private lateinit var example: LinkedListExample

    @BeforeEach
    fun setUp() {
        example = LinkedListExample()
    }

    @Test
    fun `findElement возвращает true для существующего элемента`() {
        assertTrue(example.findElement(657))
    }

    @Test
    fun `findElement возвращает false для отсутствующего элемента`() {
        assertFalse(example.findElement(999999))
    }

    @Test
    fun `removeElement удаляет существующий элемент и возвращает true`() {
        assertTrue(example.removeElement(55))
        assertFalse(example.findElement(55))
    }

    @Test
    fun `removeElement возвращает false для отсутствующего элемента`() {
        assertFalse(example.removeElement(999999))
    }

    @Test
    fun `countElements уменьшается после удаления`() {
        val before = example.countElements()
        example.removeElement(55)
        assertEquals(before - 1, example.countElements())
    }
}

class TreeSetExampleTest {

    private lateinit var example: TreeSetExample

    @BeforeEach
    fun setUp() {
        example = TreeSetExample()
    }

    @Test
    fun `findElement возвращает true для существующего элемента`() {
        assertTrue(example.findElement("BB"))
    }

    @Test
    fun `findElement возвращает false для отсутствующего элемента`() {
        assertFalse(example.findElement("ZZZ"))
    }

    @Test
    fun `removeElement удаляет существующий элемент и возвращает true`() {
        assertTrue(example.removeElement("BB"))
        assertFalse(example.findElement("BB"))
    }

    @Test
    fun `removeElement возвращает false для отсутствующего элемента`() {
        assertFalse(example.removeElement("ZZZ"))
    }

    @Test
    fun `countElements уменьшается после удаления`() {
        val before = example.countElements()
        example.removeElement("CC")
        assertEquals(before - 1, example.countElements())
    }
}

class HashMapExampleTest {

    private lateinit var example: HashMapExample

    @BeforeEach
    fun setUp() {
        example = HashMapExample()
    }

    @Test
    fun `addPerson добавляет нового человека`() {
        example.addPerson(10, Person("Test", 20))
        assertDoesNotThrow {
            example.searchPerson(10)
        }
    }

    @Test
    fun `searchPerson не выбрасывает исключений для существующего id`() {
        assertDoesNotThrow {
            example.searchPerson(1)
        }
    }

    @Test
    fun `searchPerson не выбрасывает исключений для несуществующего id`() {
        assertDoesNotThrow {
            example.searchPerson(999)
        }
    }

    @Test
    fun `removePerson удаляет существующего человека`() {
        example.removePerson(1)
        example.addPerson(1, Person("New", 1))
        assertDoesNotThrow {
            example.searchPerson(1)
        }
    }

    @Test
    fun `removePerson не выбрасывает исключений для несуществующего id`() {
        assertDoesNotThrow {
            example.removePerson(999)
        }
    }
}