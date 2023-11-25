package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class AntiColor(
    private val luminescent: ILuminescent = Luminescent(AntiColor::class),
) : ChromoCharge(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiColor::class),
    )

    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun i() : AntiColor {
        super.i()
        return this
    }
    override fun clone() : ChromoCharge {
        return AntiColor()
    }
}