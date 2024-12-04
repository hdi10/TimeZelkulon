package de.zelkulon.timezelkulon.goodtest

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.Asserter

class ArithmeticTests {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test(expected = ArithmeticException::class)
    fun failtest000001(){
        val blackHole = 1 / 0
        assertEquals(blackHole,1)
    }

    @Test
    fun gutTest000002() {
        Assert.assertEquals(100,80+20)
    }
}