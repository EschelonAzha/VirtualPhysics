package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class DbKey(
    private val antiMatter: IAntiMatter = AntiMatter(DbKey::class),
) : Compound(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(DbKey::class),
    )

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}