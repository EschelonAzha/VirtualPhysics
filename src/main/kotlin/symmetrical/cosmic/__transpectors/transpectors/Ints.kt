package symmetrical.cosmic.__transpectors.transpectors

object Ints {
    fun toByteArray(int: Int): ByteArray {
        val bytes = ByteArray(4)
        bytes[0] = (int ushr 24).toByte()
        bytes[1] = (int ushr 16).toByte()
        bytes[2] = (int ushr 8).toByte()
        bytes[3] = int.toByte()
        return bytes
    }
}