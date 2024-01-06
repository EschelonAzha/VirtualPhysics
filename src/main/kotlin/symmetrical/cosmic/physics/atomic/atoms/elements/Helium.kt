package symmetrical.cosmic.physics.atomic.atoms.elements

import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Helium
 */

class Helium(
    private val matter: IMatter = Matter(Helium::class, AntiHelium::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Helium::class, AntiHelium::class),
    )


    lateinit var atom : symmetrical.cosmic.physics.atomic.atoms.Atom


    fun i(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : symmetrical.cosmic.physics.atomic.atoms.elements.Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}