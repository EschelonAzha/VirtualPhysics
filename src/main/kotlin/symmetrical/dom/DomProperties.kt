package symmetrical.dom

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class DomProperties(
    private val matter: IMatter = Matter(DomProperties::class, DomProperties::class, true),
) : Molecular(),
    IMatter by matter
{
    constructor() : this(
        Matter(DomProperties::class, DomProperties::class, true),
    )


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

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
}