package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


class Helium(
    private val antiMatter: IAntiMatter = AntiMatter(Helium::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Helium::class),
    )


    lateinit var atom : Atom


    fun i(atom: Atom) : Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}