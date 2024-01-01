package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.matter.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue

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