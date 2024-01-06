package symmetrical.cosmic.physics.subatomic.matter.colors

import symmetrical.cosmic.physics.subatomic.balanced.color.ChromoCharge

/*
https://en.wikipedia.org/wiki/Color_charge
*/
open class Color : ChromoCharge {

    constructor()

    override fun i() : Color {
        super.i()
        return this
    }
}