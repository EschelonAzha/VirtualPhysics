package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic.physics.subatomic.matter.colors.Red

class Red_AntiBlue : Gluon {
    constructor()
    init {
        color       = Red()
        antiColor   = AntiBlue()
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