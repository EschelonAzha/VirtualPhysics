package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.matter.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue

class Blue_AntiBlue : Gluon {
    constructor()
    init {
        color       = Blue()
        antiColor   = AntiBlue()
    }


    override fun i() : Blue_AntiBlue {
        super.i()
        return this
    }

    fun blue(charge: Gluon) : Blue_AntiBlue {
        return this
    }
}