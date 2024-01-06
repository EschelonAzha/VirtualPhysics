package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic.physics.subatomic.matter.colors.Blue

class Green_AntiRed : Gluon {
    constructor()
    init {
        color       = green()
        antiColor   = AntiRed()
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