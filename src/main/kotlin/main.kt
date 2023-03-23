fun main() {
    val value = 200_000
    val paymentSystem = "Maestro"
    println(calculationCommission(value, paymentSystem, 75000))
}

fun calculationCommission(paymentValue: Int, paymentSystem: String = "VK Pay", previousPayment: Int = 0): Int {
    val errorPay = -1
    val vkDayLimit = 15_000
    val othersDayLimit = 150_000
    val vkMouthLimit = 40_000
    val othersMouthLimit = 600_000

    when (paymentSystem) {
        "VK Pay" -> if (paymentValue > vkDayLimit) return errorPay
        else -> if (paymentValue > othersDayLimit) return errorPay
    }
    when (paymentSystem) {
        "VK Pay" -> if (paymentValue + previousPayment > vkMouthLimit) return errorPay - 2
        else -> if (paymentValue + previousPayment > othersMouthLimit) return errorPay - 2
    }

    var transferFee = 0
    val minTransferFee = 35

    if (paymentSystem == "Mastercard" || paymentSystem == "Maestro") {
        if (previousPayment + paymentValue <= 75_000) transferFee else transferFee = (paymentValue * 0.006).toInt() + 20
    } else if (paymentSystem == "Visa" || paymentSystem == "Мир") {
        transferFee =
            if ((paymentValue * 0.0075).toInt() <= minTransferFee) minTransferFee else (paymentValue * 0.0075).toInt()
    } else transferFee
    return transferFee
}
