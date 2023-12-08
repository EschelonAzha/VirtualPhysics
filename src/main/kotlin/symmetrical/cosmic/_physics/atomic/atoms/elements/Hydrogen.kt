package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class Hydrogen(
    private val matter: IMatter = Matter(Hydrogen::class, AntiHydrogen::class, true),
) :
    IMatter by matter
{
    constructor() : this(
        Matter(Hydrogen::class, AntiHydrogen::class, true),
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