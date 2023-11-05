package symmetrical.cosmic.__transpectors.transpectors

object Longs {
    fun toByteArray(long: Long): ByteArray {
        val bytes = ByteArray(8)
        bytes[0] = (long ushr 56).toByte()
        bytes[1] = (long ushr 48).toByte()
        bytes[2] = (long ushr 40).toByte()
        bytes[3] = (long ushr 32).toByte()
        bytes[4] = (long ushr 24).toByte()
        bytes[5] = (long ushr 16).toByte()
        bytes[6] = (long ushr 8).toByte()
        bytes[7] = long.toByte()
        return bytes
    }
}