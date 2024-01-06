package symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors

/*
https://en.wikipedia.org/wiki/Color_charge
*/
// ORIGINAL VALUE
open class AntiGreen : AntiColor {
    constructor()

    init {
        color = ANTI_GREEN
    }


    override fun i() : AntiGreen {
        super.i()
        return this
    }
    override fun clone() : AntiGreen {
        var result      = AntiGreen()
        result.setValue(_value)
        return result
    }
}