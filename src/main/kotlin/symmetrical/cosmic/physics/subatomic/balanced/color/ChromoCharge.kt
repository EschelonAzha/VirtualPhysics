package symmetrical.cosmic.physics.subatomic.balanced.color

import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon

/*
https://en.wikipedia.org/wiki/Color_charge
*/
open class ChromoCharge : Particle {
    constructor()

    public var _value: Any? = null

    public var color :Short = COLORLESS

    companion object {
        const val COLORLESS :Short   = 0
        const val RED       :Short   = 1
        const val BLUE      :Short   = 2
        const val GREEN     :Short   = 3
        const val ANTI_RED  :Short   = -1
        const val ANTI_BLUE :Short   = -2
        const val ANTI_GREEN:Short   = -3
    }



    open fun i() : ChromoCharge {
        return this
    }
    open fun clone() : ChromoCharge {
        return ChromoCharge()
    }
    open fun getString() : String {
        return _value.toString()
    }
    fun isAntiBlue() : Boolean {
        return color == ANTI_BLUE
    }
    fun isAntiGreen() : Boolean {
        return color == ANTI_GREEN
    }
    fun isAntiRed() : Boolean {
        return color == ANTI_RED
    }
    fun isBlue() : Boolean {
        return color == BLUE
    }

    fun isGreen() : Boolean {
        return color == GREEN
    }
    fun isRed() : Boolean {
        return color == RED
    }
    fun reinitialize() : ChromoCharge {
        return this
    }
    fun setBaryon(baryon: Baryon) : ChromoCharge {
        // setQuark(baryon.quarks[0].value)
        return this
    }
//    fun setQuark(quark:Quark) : ChromoCharge {
//
//        quark.gluon.color = this as Color
//        return this
//    }

    public fun setValue(value:Any?) : ChromoCharge {
        this._value = value
        return this
    }
}