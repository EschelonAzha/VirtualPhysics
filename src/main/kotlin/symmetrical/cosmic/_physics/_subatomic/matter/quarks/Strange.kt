package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiStrange
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

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

    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun i() : Strange {
        super.i()
        return this
    }
}