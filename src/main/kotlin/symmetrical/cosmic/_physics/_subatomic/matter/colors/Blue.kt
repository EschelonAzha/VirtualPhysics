package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.matter.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Blue_AntiBlue
/*
https://en.wikipedia.org/wiki/Color_charge
*/
// PHOTON VALUE
open class Blue : Color {

    constructor()
    init {
        color = BLUE
    }

    override fun i() : Blue {
        super.i()
        return this
    }
    override fun clone() : Blue {
        var result      = Blue()
        result.setValue(_value)
        return result
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue_AntiBlue()
        gluon.color.setValue    (QCD().blue(charge.getAntiValue()))
        gluon.antiColor.setValue(charge.getAntiValue())

        return gluon
    }

}