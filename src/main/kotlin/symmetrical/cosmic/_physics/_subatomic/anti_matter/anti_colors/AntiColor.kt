package symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class AntiColor(
    private val antiMatter: IAntiMatter = AntiMatter(AntiColor::class),
) : ChromoCharge(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(AntiColor::class),
    )

    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : AntiColor {
        super.i()
        return this
    }
    override fun clone() : ChromoCharge {
        return AntiColor()
    }
}