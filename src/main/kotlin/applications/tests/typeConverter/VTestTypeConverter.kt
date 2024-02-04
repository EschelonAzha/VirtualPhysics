package applications.tests.typeConverter

import symmetrical.physics.atomic.atoms.Atom

class VTestTypeConverter {

    fun test() : Boolean {
        if (!testStringConverter()) {
            println("VTestTypeConverter::testStringConverter FAILED!!!!!!!!!!!!!!!!!!!!")
            return false
        }
        return true
    }
    private fun testStringConverter() : Boolean {
        // These conversion rules break with conventions are the most useful most of the time!

        // "FooBar"  toInt = 0           ("to" means force it to be that type)
        // "FooBar"  asInt = null        ("as" means be reasonable or be null)

        // You can also use atom.getContent() to get the exact value and type as is.


        val aString                 = "A String"
        val aEmpty                  = ""
        val aNull                   = null
        val atomString  : Atom      = Atom().with(aString)
        val atomEmpty   : Atom      = Atom().with(aEmpty)
        val atomNull    : Atom      = Atom().with(aNull)


        val trueValue   : Any?      = atomString.getContent()  //<---- as is

        var asByte      : Byte?     = atomString.asByte()
        var toByte      : Byte      = atomString.toByte()
        var asBoolean   : Boolean?  = atomString.asBoolean()
        var toBoolean   : Boolean   = atomString.toBoolean()
        var asDouble    : Double?   = atomString.asDouble()
        var toDouble    : Double    = atomString.toDouble()
        var asInt       : Int?      = atomString.asInt()
        var toInt       : Int       = atomString.toInt()
        var asString    : String?   = atomString.asString()
        var toString    : String    = atomString.toString()

        if (asByte!!.toChar() != 'A')   // take the first byte
            return false
        if (toByte.toChar() != 'A')     // take the first byte
            return false
        if (asBoolean != true)          // if it has a value, then it is true
            return false
        if (toBoolean != true)          // if it has a value, then it is true
            return false
        if (asDouble != null)           // Can't convert a string to a double so return null
            return false
        if (toDouble != 0.0)            // Returning 0.0 is more reasonable than 873.27
            return false
        if (asInt != null)              // Can't convert a string to an int so return null
            return false
        if (toInt != 0)                 // Returning 0 is better than 42
            return false
        if (asString != aString)        // Strings return as is
            return false
        if (toString != aString)        // Strings return as is
            return false


        asByte          = atomEmpty.asByte()
        toByte          = atomEmpty.toByte()
        asBoolean       = atomEmpty.asBoolean()
        toBoolean       = atomEmpty.toBoolean()
        asDouble        = atomEmpty.asDouble()
        toDouble        = atomEmpty.toDouble()
        asInt           = atomEmpty.asInt()
        toInt           = atomEmpty.toInt()
        asString        = atomEmpty.asString()
        toString        = atomEmpty.toString()

        if (asByte != null)                 // The first byte of an empty String is null
            return false
        if (toByte != 0.toByte())           // if there is no first byte then return zero
            return false
        if (asBoolean != false)             // An empty string is false
            return false
        if (toBoolean != false)             // An empty string is false
            return false
        if (asDouble != null)               // An Empty String returns null
            return false
        if (toDouble != 0.0)                // An Empty String is 0.0
            return false
        if (asInt != null)                  // An Empty String returns null
            return false
        if (toInt != 0)                     // An Empty String returns 0
            return false
        if (asString != aEmpty)             // Strings return as is
            return false
        if (toString != aEmpty)             // Strings return as is
            return false

        asByte          = atomNull.asByte()
        toByte          = atomNull.toByte()
        asBoolean       = atomNull.asBoolean()
        toBoolean       = atomNull.toBoolean()
        asDouble        = atomNull.asDouble()
        toDouble        = atomNull.toDouble()
        asInt           = atomNull.asInt()
        toInt           = atomNull.toInt()
        asString        = atomNull.asString()
        toString        = atomNull.toString()

        if (asByte != null)                 // A null String returns a null byte
            return false
        if (toByte != 0.toByte())           // A null String returns 0 byte
            return false
        if (asBoolean != null)              // A null String returns null
            return false
        if (toBoolean != false)             // A null String returns false
            return false
        if (asDouble != null)               // A null String returns null
            return false
        if (toDouble != 0.0)                // A null String returns 0.0
            return false
        if (asInt != null)                  // A null String returns null
            return false
        if (toInt != 0)                     // A null String returns 0
            return false
        if (asString != aNull)              // Strings return as is
            return false
        if (toString != aEmpty)             // Strings reurn as is
            return false

        return true
    }
}