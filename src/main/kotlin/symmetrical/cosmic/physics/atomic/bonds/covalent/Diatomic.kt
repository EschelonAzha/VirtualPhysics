package symmetrical.cosmic.physics.atomic.bonds.covalent

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Diatomic_molecule
 */
open class Diatomic(
    private val matter: IMatter = Matter(Diatomic::class, Diatomic::class),
) : Molecular(),
    IMatter by matter
{
    constructor() : this(
        Matter(Diatomic::class, Diatomic::class),
    )
    object Static {
        const val LAST      : Int = -1
    }

    constructor(atom1: Atom, atom2: Atom) : this() {
        add(atom1)
        add(atom2)
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

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