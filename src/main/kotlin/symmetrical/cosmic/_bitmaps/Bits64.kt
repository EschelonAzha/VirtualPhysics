package symmetrical.cosmic._bitmaps

import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Bits64 (
    private val luminescent: ILuminescent = Luminescent(Bits64::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Bits64::class),
    )

    private var high   : Bits32 = Bits32()
    private var low    : Bits32 = Bits32()

    init {
        high  = Bits32(0u, 0u, 0u, 0u)
        low   = Bits32(0u, 0u, 0u, 0u)
    }

    constructor(byte1:UByte=0u, byte2:UByte=0u, byte3:UByte=0u, byte4:UByte=0u, byte5:UByte=0u, byte6:UByte=0u, byte7:UByte=0u, byte8:UByte=0u) : this() {
        high  = Bits32(byte1, byte2, byte3, byte4)
        low   = Bits32(byte5, byte6, byte7, byte8)
    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte(),byteArray[2].toUByte(), byteArray[3].toUByte(),byteArray[4].toUByte(), byteArray[5].toUByte(),byteArray[6].toUByte(), byteArray[7].toUByte()) {
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun toString() : String {
        return "$high :: $low"
    }
    fun toDecimal() : Long {
        val high:Long = high.toDecimal() * 4294967296
        val low :Long = low.toDecimal().toLong()
        return high + low
    }
}