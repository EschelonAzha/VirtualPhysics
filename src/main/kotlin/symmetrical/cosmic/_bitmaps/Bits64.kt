package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Bits64 {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    private val high   : Bits32
    private val low    : Bits32

    constructor() : this(0.toUByte(), 0.toUByte(), 0.toUByte(), 0.toUByte(), 0.toUByte(), 0.toUByte(), 0.toUByte(), 0.toUByte()){

    }
    constructor(byte1:UByte, byte2:UByte, byte3:UByte, byte4:UByte, byte5:UByte, byte6:UByte, byte7:UByte, byte8:UByte) {
        high  = Bits32(byte1, byte2, byte3, byte4)
        low   = Bits32(byte5, byte6, byte7, byte8)
    }
    constructor(byteArray:ByteArray) :this(byteArray[0].toUByte(), byteArray[1].toUByte(),byteArray[2].toUByte(), byteArray[3].toUByte(),byteArray[4].toUByte(), byteArray[5].toUByte(),byteArray[6].toUByte(), byteArray[7].toUByte()) {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bits64::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
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