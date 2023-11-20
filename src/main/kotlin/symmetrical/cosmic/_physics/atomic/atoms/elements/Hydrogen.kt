package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Hydrogen(
    private val fermion: IFermion = Fermion(),
) :
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    lateinit var atom : Atom


    constructor(atom: Atom) : this(Fermion()) {
        this.atom = atom
    }
    fun i(atom: Atom) : Hydrogen {
        this.atom = atom
        atom.setAtomicNumber(1)
        return this
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Hydrogen::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}