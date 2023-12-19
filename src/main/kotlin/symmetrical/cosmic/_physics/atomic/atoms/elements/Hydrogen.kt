package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom

class Hydrogen(
    private val matter: IMatter = Matter(Hydrogen::class, AntiHydrogen::class),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Hydrogen::class, AntiHydrogen::class),
    )


    lateinit var atom : Atom


    constructor(atom: Atom) : this() {
        this.atom = atom
    }
    fun i(atom: Atom) : Hydrogen {
        this.atom = atom
        atom.setAtomicNumber(1)
        return this
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
}