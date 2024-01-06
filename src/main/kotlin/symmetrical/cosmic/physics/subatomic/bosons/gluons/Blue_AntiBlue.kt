package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic.physics.subatomic.matter.colors.Blue

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