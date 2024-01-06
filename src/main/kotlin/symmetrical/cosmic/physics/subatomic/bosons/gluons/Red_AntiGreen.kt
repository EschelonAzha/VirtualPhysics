package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic.physics.subatomic.matter.colors.Blue
import symmetrical.cosmic.physics.subatomic.matter.colors.Red

class Red_AntiGreen : Gluon {
    constructor()
    init {
        color       = Red()
        antiColor   = AntiGreen()
    }

    override fun i() : Red_AntiGreen {
        super.i()
        return this
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue().blue(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}