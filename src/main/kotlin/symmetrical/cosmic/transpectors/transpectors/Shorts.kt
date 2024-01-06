package symmetrical.cosmic.transpectors.transpectors

object Shorts {
    fun toByteArray(short: Short): ByteArray {
        val bytes = ByteArray(2)
        val int = short.toInt()
        bytes[0] = ((int) ushr 8).toByte()
        bytes[1] = short.toByte()
        return bytes
    }
    fun toByteArray(short:UShort) : ByteArray {
        return toByteArray(short.toShort())
    }
}