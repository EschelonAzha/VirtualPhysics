package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class QBoolean(
    private val matter: IMatter = Matter(QBoolean::class, QBoolean::class, true),
) : Atom(),
    IMatter by matter
{
    constructor() : this(
        Matter(QBoolean::class, QBoolean::class, true),
    )  init {
        setBoolean(false)
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    override fun red() : Boolean {
        return nucleons.getValueProton().red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        setQuarkValue(value)
        return this
    }
}