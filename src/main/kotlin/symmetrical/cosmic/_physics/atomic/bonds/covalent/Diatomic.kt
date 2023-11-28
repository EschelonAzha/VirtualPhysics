package symmetrical.cosmic._physics.atomic.bonds.covalent

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Diatomic(
    private val antiMatter: IAntiMatter = AntiMatter(Diatomic::class),
) : Molecular(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Diatomic::class),
    )
    object Static {
        const val LAST      : Int = -1
    }

    constructor(atom1: Atom, atom2:Atom) : this() {
        add(atom1)
        add(atom2)
    }


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