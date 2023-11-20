package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Hydrogen(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )

    lateinit var atom : Atom


    constructor(atom: Atom) : this(QuantumEntanglement()) {
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