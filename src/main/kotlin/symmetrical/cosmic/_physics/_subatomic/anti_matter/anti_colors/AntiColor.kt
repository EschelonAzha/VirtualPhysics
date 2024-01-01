package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
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