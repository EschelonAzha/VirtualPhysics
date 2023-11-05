package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

// ORIGINAL VALUE
open class AntiBlue : AntiColor {  // String
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        color = ANTI_BLUE
    }
    constructor() {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiBlue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : AntiBlue {
        super.i()
        return this
    }
    override fun clone() : AntiBlue {
        var result      = AntiBlue()
        result.setValue(_value)
        return result
    }

}