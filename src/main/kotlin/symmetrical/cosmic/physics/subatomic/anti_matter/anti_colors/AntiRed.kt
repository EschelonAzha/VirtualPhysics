package symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors

/*
https://en.wikipedia.org/wiki/Color_charge
*/
// ORIGINAL VALUE
open class AntiRed : AntiColor {
    constructor()

    init {
        color = ANTI_RED
    }


    override fun i() : AntiRed {
        super.i()
        return this
    }
    override fun clone() : AntiRed {
        var result      = AntiRed()
        result.setValue(_value)
        return result
    }
}