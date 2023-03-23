fun main() {
    val value = 1000
    val paymentSystem = "Maestro"
    println(calculationCommission(value, paymentSystem, 75000))

}

fun calculationCommission(paymentValue: Int, paymentSystem: String = "VK pay", previousPayment: Int = 0): Int {
    var transferFee = 0
    val minTransferFee = 35
    if (paymentSystem == "Mastercard" || paymentSystem == "Maestro") {
        if (previousPayment + paymentValue <= 75_000) transferFee else transferFee = (paymentValue * 0.006).toInt() + 20
    } else if (paymentSystem == "Visa" || paymentSystem == "Мир") {
        if ((paymentValue * 0.0075).toInt() <= minTransferFee) minTransferFee else transferFee =
            (paymentValue * 0.0075).toInt()
    } else transferFee
    return transferFee

}
