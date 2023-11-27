package symmetrical.cosmic._physics.atomic.substance.molecules

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Covalent
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Molecule(
    private val antiMatter: IAntiMatter = AntiMatter(Molecule::class),
) : Molecular(),
    IAntiMatter by antiMatter,
    Covalent
{
    constructor() : this(
        AntiMatter(Molecule::class),
    )
    object Static {
        const val LAST      : Int = -1
    }



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return antiMatter.getClassId()+remainder
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}