package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Helium(
    private val luminescent: ILuminescent = Luminescent(Helium::class),
) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Helium::class),
    )
    lateinit var atom : Atom


    fun i(atom: Atom) : Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}