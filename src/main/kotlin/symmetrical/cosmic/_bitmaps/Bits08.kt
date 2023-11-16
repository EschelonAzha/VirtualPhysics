package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Bits08 (
    private val entanglement:IQuantumEntanglement
) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement(),
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

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bits08::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
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