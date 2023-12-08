package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.ionic.Ionic
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Compound(
    private val matter: IMatter = Matter(Compound::class, Compound::class, true),
) : Molecular(),
    IMatter by matter,
    Ionic
{
    constructor() : this(
        Matter(Compound::class, Compound::class, true),
    )
    object Static {
        const val LAST      : Int = -1
    }



    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return matter.getClassId()+remainder
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }

    override fun i() : Compound {
        super.i();
        return this
    }
}