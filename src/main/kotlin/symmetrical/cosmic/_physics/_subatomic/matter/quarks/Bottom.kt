package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiBottom
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/BottomQuark
 */
class Bottom(
    private val matter: IMatter = Matter(Bottom::class, AntiBottom::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Bottom::class, AntiBottom::class),
    )
    init {

    }
    override fun i() : Bottom {
        super.i()
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}