package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic.physics.subatomic.matter.colors.Blue

class Blue_AntiRed  : Gluon {
    constructor()
    init {
        color       = Blue()
        antiColor   = AntiRed()
    }

    override fun i() : Blue_AntiRed {
        super.i()
        return this
    }
    fun green(charge: Gluon) : Green_AntiGreen {
        var gluon = charge.green().green(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }

}