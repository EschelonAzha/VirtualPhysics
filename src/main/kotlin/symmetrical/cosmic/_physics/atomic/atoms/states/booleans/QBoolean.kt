package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class QBoolean(
    private val antiMatter: AntiMatter = AntiMatter(QBoolean::class, QBoolean::class),
) : Atom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(QBoolean::class, QBoolean::class),
    )  init {
        setBoolean(false)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun red() : Boolean {
        return nucleons.getValueProton().red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        setQuarkValue(value)
        return this
    }
}