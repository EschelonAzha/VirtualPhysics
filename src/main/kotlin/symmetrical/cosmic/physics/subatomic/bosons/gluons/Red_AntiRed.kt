package symmetrical.cosmic.physics.subatomic.bosons.gluons

import symmetrical.cosmic.physics.subatomic.matter.bosons.Gluon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic.physics.subatomic.matter.colors.Red


class Red_AntiRed : Gluon {
    constructor()   init {
        color       = Red()
        antiColor   = AntiRed()
    }


    override fun i() : Red_AntiRed {
        super.i()
        return this
    }
    override fun getAntiValue() : Any? {
        return color._value
    }
    override fun setValue(value:Any?) : Gluon {
        color.setValue(value)

        return this
    }
    fun red(charge: Gluon) : Red_AntiRed {
        return this
    }
}