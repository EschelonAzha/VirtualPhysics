package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Helium(
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )
    lateinit var atom : Atom


    fun i(atom: Atom) : Helium {
        this.atom = atom
        atom.setAtomicNumber(2)
        return this
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Helium::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}