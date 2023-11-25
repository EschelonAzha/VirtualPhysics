package symmetrical.cosmic._bitmaps

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Bits08 (
    private val luminescent: ILuminescent = Luminescent(Bits08::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Bits08::class),
    )

    lateinit var high: Bits04
    lateinit var low: Bits04

    private var byte: UByte = 0u


    constructor(byte: UByte) : this() {
        this.byte = byte
        setDecimal(byte)
    }
    constructor(high: Bits04, low: Bits04) : this() {
        this.high = high
        this.low  = low
        this.byte = toDecimal().toUByte()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun toString() : String {
        return "$high $low"
    }
    fun getByte() : UByte {
        return byte
    }
    fun toDecimal() : Int {
        val upper: Int = high.toDecimal() * 16
        val lower: Int = low.toDecimal()
        return upper+lower;
    }
    fun setDecimal(value:UByte) : Bits08 {
        this.byte = value
        val highNibble: UByte = ((byte.toInt() shr 4) and 0x0F).toUByte()
        val lowNibble: UByte = (byte and 15u).toUByte()
        high = Bits04(highNibble)
        low = Bits04(lowNibble)
        return this
    }

    fun size() : Int {
        return 1
    }
}