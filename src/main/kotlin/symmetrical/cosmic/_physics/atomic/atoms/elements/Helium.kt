package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


class Helium(
    private val matter: IMatter = Matter(Helium::class, AntiHelium::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Helium::class, AntiHelium::class),
    )


    lateinit var atom : Atom


    fun i(atom: Atom) : Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}