package asymmetrical.machine.transpectors

object ABytes {
    fun toByteArray(charArray:CharArray) : ByteArray {
        return charArray.joinToString("").toByteArray(Charsets.UTF_8)
    }
    fun toCharArray(byteArray:ByteArray) : CharArray {
        return String(byteArray, Charsets.UTF_8).toCharArray()
    }
    fun toString(byteArray:ByteArray) : String {
        return byteArray.toString(Charsets.UTF_8)
    }
}