package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Red_AntiBlue : Gluon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {
        color       = Red()
        antiColor   = AntiBlue()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Red_AntiBlue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Red_AntiBlue {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        var gluon = charge.green().green(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}