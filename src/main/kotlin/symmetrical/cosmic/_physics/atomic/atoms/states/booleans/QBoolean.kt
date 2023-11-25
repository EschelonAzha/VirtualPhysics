package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class QBoolean(
    private val fermion: Luminescent = Luminescent(QBoolean::class),
) : Atom(),
    ILuminescent by fermion
{
    constructor() : this(
        Luminescent(QBoolean::class),
    )  init {
        setBoolean(false)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun red() : Boolean {
        return nucleons.getValueProton().red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        setQuarkValue(value)
        return this
    }
}