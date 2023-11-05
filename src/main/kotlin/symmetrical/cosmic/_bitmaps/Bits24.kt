package symmetrical.cosmic._bitmaps

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Bits24 {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    val top     : Bits08
    val middle  : Bits08
    val bottom  : Bits08
    constructor() {
        top    = Bits08()
        middle = Bits08()
        bottom = Bits08()
    }
    constructor(byte1:UByte, byte2:UByte, byte3:UByte) {
        top     = Bits08(byte1)
        middle  = Bits08(byte2)
        bottom  = Bits08(byte3)
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Bits24::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun size() : Int {
        return 3
    }
    override fun toString() : String {
        return "$top : $middle : $bottom"
    }
}