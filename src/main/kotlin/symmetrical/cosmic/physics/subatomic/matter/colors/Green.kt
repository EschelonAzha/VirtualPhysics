package symmetrical.cosmic.physics.subatomic.matter.colors

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.balanced.color.QCD
import symmetrical.cosmic.physics.subatomic.bosons.gluons.Green_AntiGreen
/*
https://en.wikipedia.org/wiki/Color_charge
*/
// FORMATTED VALUE
open class Green : Color {
    constructor()
    init {
        color = GREEN
    }


    override fun i() : Green {
        super.i()
        return this
    }
    override fun clone() : Green {
        var result      = Green()
        result.setValue(_value)
        return result
    }
    open fun format(redValue:Any?) : Any? {
        return QCD().green(redValue)
    }
    open fun green(charge: Gluon) : Green_AntiGreen {
        var gluon               = Green_AntiGreen()
        gluon.antiColor.setValue(charge.getAntiValue())
        gluon.color.setValue    (format(charge.getAntiValue()))
        return gluon
    }


}