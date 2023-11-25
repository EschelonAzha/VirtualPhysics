package symmetrical.cosmic._physics.atomic.substance.molecules

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Covalent
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

open class Molecule(
    private val fermion: ILuminescent = Luminescent(Molecule::class),
) : Molecular(),
    ILuminescent by fermion,
    Covalent
{
    constructor() : this(
        Luminescent(Molecule::class),
    )  {
        fermion.setKClass(Molecule::class)
    }
    object Static {
        const val LAST      : Int = -1
    }



    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return fermion.getClassId()+remainder
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
}