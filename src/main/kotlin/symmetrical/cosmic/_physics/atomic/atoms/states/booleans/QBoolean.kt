package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class QBoolean(
    private val fermion: QuantumEntanglement = QuantumEntanglement(),
) : Atom(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
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