package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.substance.ions.Compound
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

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