package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Hydrogen(
    private val antiMatter: IAntiMatter = AntiMatter(Hydrogen::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Hydrogen::class),
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
        return antiMatter.getClassId()
    }
}