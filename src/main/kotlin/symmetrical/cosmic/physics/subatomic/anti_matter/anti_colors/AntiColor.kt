package symmetrical.cosmic.physics.subatomic.anti_matter.anti_colors

import symmetrical.cosmic.physics.subatomic.balanced.color.ChromoCharge


/*
https://en.wikipedia.org/wiki/Color_charge
*/
open class AntiColor : ChromoCharge {

    constructor() {
    }

    override fun i() : AntiColor {
        super.i()
        return this
    }
    override fun clone() : ChromoCharge {
        return AntiColor()
    }
}