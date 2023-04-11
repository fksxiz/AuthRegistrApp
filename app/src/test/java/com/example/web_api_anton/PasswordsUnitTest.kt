package com.example.web_api_anton

import android.util.Log
import com.example.web_api_anton.Validator.validatePassword
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PasswordsUnitTest {
    @Test
    fun check_password4Symbols_returnFalse() {
        assertEquals(false, validatePassword("Aq1\$"))
    }

    @Test
    fun check_password8Symbols_returnTrue() {
        assertEquals(true, validatePassword("ASqw12\$\$"))
    }

    @Test
    fun check_password30Symbols_returnFalse() {
        assertEquals(false, validatePassword("ASDqwe123\$ASDqwe123\$ASDqwe123\$"))
    }

    @Test
    fun check_passwordWithDigits_returnTrue() {
        assertEquals(true, validatePassword("ASDqwe1\$"))
    }

    @Test
    fun check_passwordWithoutDigits_returnFalse() {
        assertEquals(false, validatePassword("ASDqweASD\$"))
    }

    @Test
    fun check_passwordWithSpecSymbols_returnTrue() {
        assertEquals(true, validatePassword("Aqwe123\$"))
    }

    @Test
    fun check_passwordWithoutSpecSymbols_returnFalse() {
        assertEquals(false, validatePassword("ASDqwe123"))
    }

    @Test
    fun check_passwordWithUpperCase_returnTrue() {
        assertEquals(true, validatePassword("Aqwe123\$"))
    }

    @Test
    fun check_passwordWithoutUpperCase_returnFalse() {
        assertEquals(false, validatePassword("asdqwe123\$"))
    }

    @Test
    fun check_passwordWithLowerCase_returnTrue() {
        assertEquals(true, validatePassword("ASDq123\$"))
    }

    @Test
    fun check_passwordWithoutLowerCase_returnFalse() {
        assertEquals(false, validatePassword("ASDQWE123\$"))
    }
}