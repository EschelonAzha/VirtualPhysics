package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__transpectors.transpectors.Ints
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Bits32 {
    constructor()

    private var high   : Bits16 = Bits16()
    private var low    : Bits16 = Bits16()

    constructor(byte1:UByte, byte2:UByte, byte3:UByte, byte4:UByte) : this() {
        high  = Bits16(byte1, byte2)
        low   = Bits16(byte3, byte4)

    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte(),byteArray[2].toUByte(), byteArray[3].toUByte()) {
    }
    constructor(value:Int=0) : this() {
        val byteArray = Ints.toByteArray(value)
        high = Bits16(byteArray[0].toUByte(), byteArray[1].toUByte())
        low  = Bits16(byteArray[2].toUByte(), byteArray[3].toUByte())
    }


    fun getByteArray() : ByteArray {
        var result = ByteArray(4)
        val highArray:ByteArray  = high.getByteArray()
        val lowArray :ByteArray  = low.getByteArray()
        result[0] = highArray[0]
        result[1] = highArray[1]
        result[2] = lowArray[0]
        result[3] = lowArray[1]
        return result
    }

    fun size() : Int {
        return 4
    }
    override fun toString() : String {
        return "$high :: $low"
    }
    fun toDecimal() : Int {
        val high:Int = high.toDecimal() * 65536
        val low :Int = low.toDecimal()
        return high + low
    }
}