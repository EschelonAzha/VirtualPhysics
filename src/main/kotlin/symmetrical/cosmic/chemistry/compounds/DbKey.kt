package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class DbKey(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Compound(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
}