package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic.physics.subatomic.matter.colors.Red

class Green_AntiBlue : Gluon {
    constructor()
    init {
        color       = green()
        antiColor   = AntiBlue()
    }


    override fun i() : Green_AntiBlue {
        super.i()
        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red().red(charge)
        gluon.manifestation = charge.manifestation
        return gluon
    }
}