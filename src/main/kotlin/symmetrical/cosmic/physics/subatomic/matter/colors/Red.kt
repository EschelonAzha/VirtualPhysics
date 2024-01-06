package symmetrical.cosmic.physics.subatomic.matter.colors

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.bosons.gluons.Red_AntiRed
/*
https://en.wikipedia.org/wiki/Color_charge
*/
// ACTUAL VALUE
open class Red : Color {
    constructor()
    init {
        color = RED
    }

    override fun clone() : Red {
        var result      = Red()
        result.setValue(_value)
        return result
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red_AntiRed()
        gluon.setValue    (charge.getAntiValue())
        return gluon
    }
}