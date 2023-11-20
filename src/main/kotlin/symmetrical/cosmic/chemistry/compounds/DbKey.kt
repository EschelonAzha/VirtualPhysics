package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class DbKey(
    private val fermion: IFermion = Fermion()
) : Compound(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    )

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
}