package symmetrical.cosmic.physics.subatomic.matter.quarks

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiStrange
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/StrangeQuark
 */
class Strange(
    private val matter: IMatter = Matter(Strange::class, AntiStrange::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Strange::class, AntiStrange::class),
    )
    init {
    }

    override fun i() : Strange {
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