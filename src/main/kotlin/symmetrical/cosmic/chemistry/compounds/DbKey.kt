package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.cosmic._physics.atomic.atoms.Atom

class DbKey(
    private val matter: IMatter = Matter(DbKey::class, DbKey::class),
) : Compound(),
    IMatter by matter
{
    constructor() : this(
        Matter(DbKey::class, DbKey::class),
    )

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
}