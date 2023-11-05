package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

// ORIGINAL VALUE
open class AntiRed : AntiColor {  // Byte
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        color = ANTI_RED
    }
    constructor() {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiRed::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}