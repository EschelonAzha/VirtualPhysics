package symmetrical.cosmic._physics.atomic.substance.molecules

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Covalent
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class Molecule(
    private val matter: IMatter = Matter(Molecule::class, Molecule::class, true),
) : Molecular(),
    IMatter by matter,
    Covalent
{
    constructor() : this(
        Matter(Molecule::class, Molecule::class, true),
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
}