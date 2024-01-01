package symmetrical.cosmic._physics.atomic.substance.molecules

import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics.atomic.bonds.covalent.Covalent
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
/*
https://en.wikipedia.org/wiki/Molecule
 */
open class Molecule(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Molecule::class, Molecule::class),
) : Molecular(),
    IMatterAntiMatter by matterAntiMatter,
    Covalent
{
    constructor() : this(
        MatterAntiMatter(Molecule::class, Molecule::class),
    )
    object Static {
        const val LAST      : Int = -1
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }

}