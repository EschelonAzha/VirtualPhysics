package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

open class Color: ChromoCharge {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
    }
    override public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Color::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}