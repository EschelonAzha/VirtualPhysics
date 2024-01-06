package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic.physics.subatomic.matter.colors.Blue
import symmetrical.cosmic.physics.subatomic.matter.colors.Red


class Blue_AntiGreen : Gluon {
    constructor()
    init {
        color       = Blue()
        antiColor   = AntiGreen()
    }

    override fun i() : Blue_AntiGreen {
        super.i()
        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red().red(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}