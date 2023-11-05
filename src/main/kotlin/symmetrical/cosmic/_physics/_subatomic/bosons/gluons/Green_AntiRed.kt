package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Green_AntiRed : Gluon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
        color       = green()
        antiColor   = AntiRed()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Green_AntiRed::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Green_AntiRed {
        super.i()
        return this
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}