package symmetrical.dom

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class DomProperties(
    private val antiMatter: IAntiMatter = AntiMatter(DomProperties::class, DomProperties::class),
) : Molecular(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(DomProperties::class, DomProperties::class),
    )


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}