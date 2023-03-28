import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    // Суточный лимит ВК
    fun calculationCommissionVkDayLimit() {
        val paymentValue = 100_000
        val previousPayment = 0

        val result = calculationCommission(paymentValue, "VK Pay", previousPayment)
        assertEquals(-1, result)
    }

    @Test
    // Суточный лимит других платежных систем
    fun calculationCommissionOtherDayLimit() {
        val paymentValue = 151_000
        val previousPayment = 0
        val paymentSystem = "Mastercard"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(-1, result)
    }

    @Test
    // Месячный лимит ВК
    fun calculationCommissionVkMountLimit() {
        val paymentValue = 14_000
        val previousPayment = 39_000

        val result = calculationCommission(paymentValue, "VK Pay", previousPayment)
        assertEquals(-3, result)
    }

    @Test
    // Месячный лимит других платежных систем
    fun calculationCommissionOtherMountLimit() {
        val paymentValue = 150_000
        val previousPayment = 451_000
        val paymentSystem = "Mastercard"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(-3, result)
    }
    @Test
    // комиссия мастеркард
    fun calculationCommissionMastercard() {
        val paymentValue = 150_000
        val previousPayment = 450_000
        val paymentSystem = "Mastercard"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(920, result)
    }

    @Test
    // без комисси мастеркард
    fun calculationNoCommissionMastercard() {
        val paymentValue = 73_000
        val previousPayment = 1000
        val paymentSystem = "Mastercard"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(0, result)
    }

    @Test
    //комиссия маэстро
    fun calculationCommissionMaestro() {
        val paymentValue = 150_000
        val previousPayment = 450_000
        val paymentSystem = "Maestro"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(920, result)
    }

    @Test
    // без комиссии маэстро
    fun calculationNoCommissionMaestro() {
        val paymentValue = 73_000
        val previousPayment = 1000
        val paymentSystem = "Maestro"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(0, result)
    }
    @Test

    fun calculationCommissionVisa() {
        val paymentValue = 150_000
        val previousPayment = 450_000
        val paymentSystem = "Visa"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(1125, result)
    }

    @Test
    fun calculationMinCommissionVisa() {
        val paymentValue = 1_000
        val previousPayment = 450_000
        val paymentSystem = "Visa"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(35, result)
    }
    @Test
    fun calculationCommissionMir() {
        val paymentValue = 150_000
        val previousPayment = 450_000
        val paymentSystem = "Мир"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(1125, result)
    }

    @Test
    fun calculationMinCommissionMir() {
        val paymentValue = 1_000
        val previousPayment = 450_000
        val paymentSystem = "Мир"

        val result = calculationCommission(paymentValue, paymentSystem, previousPayment)
        assertEquals(35, result)
    }

    @Test
    fun calculationCommissionVkPay() {
        val paymentValue = 14_000
        val previousPayment = 20_000

        val result = calculationCommission(paymentValue, "VK Pay", previousPayment)
        assertEquals(5, result)
    }
}