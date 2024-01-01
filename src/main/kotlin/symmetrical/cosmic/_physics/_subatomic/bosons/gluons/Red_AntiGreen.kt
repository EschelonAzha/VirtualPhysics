package symmetrical.cosmic._physics._subatomic.bosons.gluons

import symmetrical.cosmic._physics._subatomic.matter.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Red

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