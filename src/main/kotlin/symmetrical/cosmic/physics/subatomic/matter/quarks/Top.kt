package symmetrical.cosmic.physics.subatomic.matter.quarks

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiTop
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/TopQuark
 */
class Top(
    private val matter: IMatter = Matter(Top::class, AntiTop::class),
) : Quark(),
    IMatter by matter
{
    constructor() : this(
        Matter(Top::class, AntiTop::class),
    )
    init {
    }
    override fun i() : Top {
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