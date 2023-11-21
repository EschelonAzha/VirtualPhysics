package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Shorts
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Bits16 (
    private val fermion: IFermion = Fermion(Bits16::class),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Bits16::class),
    )
    private var high: Bits08 = Bits08()
    private var low : Bits08 = Bits08()

    constructor(byte1:UByte, byte2:UByte) : this() {
        high = Bits08(byte1)
        low  = Bits08(byte2)
    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte()) {
    }
    constructor(value:UShort) : this() {
        val byteArray = Shorts.toByteArray(value)
        high = Bits08(byteArray[0].toUByte())
        low  = Bits08(byteArray[1].toUByte())
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }

    fun getByteArray() : ByteArray {
        var result = ByteArray(2)
        result[0] = high.getByte().toByte()
        result[1] = low.getByte().toByte()
        return result
    }

    override fun toString() : String {
        return "$high : $low"
    }

    fun size() : Int {
        return 2
    }
    fun toDecimal(): Int {
        return (high.getByte().toInt() shl 8) or (low.getByte().toInt() and 0xFF)
    }
}