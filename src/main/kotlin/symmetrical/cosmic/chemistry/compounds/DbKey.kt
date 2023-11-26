package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class DbKey(
    private val luminescent: ILuminescent = Luminescent(DbKey::class),
) : Compound(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(DbKey::class),
    )

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}