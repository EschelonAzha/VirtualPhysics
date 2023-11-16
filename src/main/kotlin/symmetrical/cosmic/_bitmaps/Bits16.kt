package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Shorts
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Bits16 (
    private val entanglement:IQuantumEntanglement
) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    ) {}

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

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bits16::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
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