package symmetrical.cosmic.transpectors.transpectors

import asymmetrical.physics.machine.transpectors.ABytes


object Strings {

    fun chop(number:Int, str:String) : String {
        return str.substring(number)
    }
    fun crlfTerminated(value:String) : String {
        return value+"\r\n"
    }
    fun nullTerminated(value:String) : String {
        return value + '\u0000'
    }
    fun remainder(number:Int, str:String) : Pair<String, String> {
        val leading:String = str.substring(0, number)
        val remaining:String = str.substring(number)
        return  Pair<String, String>(leading, remaining)
    }
    fun removeCharacter(characterToRemove: Char, value: String): String {
        var charArray:CharArray = value.toCharArray()
        var result:String = ""
        for (i in charArray.indices) {
            if (charArray[i] != characterToRemove){
                result += charArray[i]
            }
        }
        return result
    }
    fun removeDoubleQuotes(text:String) : String {
        return removeBookends(text);
    }
    fun removeSingleQuotes(text:String) : String {
        return removeBookends(text);
    }

    fun scramble(payload:String, pattern:Int=44) : String {

        val byteArray = toByteArray(payload)

        val mod = byteArray.size % 2
        var size = byteArray.size
        if (mod == 1) {
            size--
        }
        var result = ByteArray(byteArray.size)
        for (i in 0 until size step 2) {
            val first :Byte = byteArray[i]
            val second:Byte = byteArray[i+1]
            var mangled:Pair<Byte, Byte>
            if (pattern == 44)
                mangled = Bytes.mangleBytes44(first, second)
            else mangled = Bytes.mangleBytes53(first, second)
            result[i] = mangled.first
            result[i+1] = mangled.second
        }
        if (mod == 1) {
            result[size] = byteArray[size]
        }

        return Bytes.toString(result)

    }
    fun toByteArray(str: String): ByteArray {
        return ABytes.toByteArray(str.toCharArray())
    }

    fun toDelimitedString(delimiter:String, array: Array<Any?>) : String {
        if (array.isEmpty())
            return ""

        var result = array[0].toString()
        for (i in 1 until array.size) {
            result += delimiter
            result += array[i].toString()
        }

        return result
    }
    fun toFixedLength(lth:Int, padChar:String, value:String) : String {
        var result = value;
        while (result.length < lth) {
            result = padChar+result;
        }
        return result;
    }
    fun trimLeading(character:String, value:String) : String {
        return value.trimStart(character[0])
    }
    private fun removeBookends(text:String) : String {
        return text.substring(1, text.length-1);
    }
}