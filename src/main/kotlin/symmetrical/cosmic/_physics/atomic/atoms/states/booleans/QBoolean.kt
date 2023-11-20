package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class QBoolean(
    private val fermion: Fermion = Fermion(),
) : Atom(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        setBoolean(false)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QBoolean::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Boolean {
        return nucleons.getValueProton().red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        setQuarkValue(value)
        return this
    }
}