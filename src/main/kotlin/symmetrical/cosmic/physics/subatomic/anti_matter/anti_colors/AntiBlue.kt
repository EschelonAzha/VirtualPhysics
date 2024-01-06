package symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors

/*
https://en.wikipedia.org/wiki/Color_charge
*/

// ORIGINAL VALUE
open class AntiBlue : AntiColor {
    constructor()
    init {
        color = ANTI_BLUE
    }

    override fun i() : AntiBlue {
        super.i()
        return this
    }
    override fun clone() : AntiBlue {
        var result      = AntiBlue()
        result.setValue(_value)
        return result
    }

}