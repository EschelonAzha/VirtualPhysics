package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


class QDouble(
    private val entanglement: QuantumEntanglement = QuantumEntanglement()
) : Atom(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    ) init {
        setDouble(0.0)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QDouble::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Double {
        return nucleons.getValueProton().red() as Double
    }
    override fun getElectronWavelength() : Double {
        return super.getElectronWavelength() as Double
    }
    fun setDouble(value:Double) : QDouble {
        setQuarkValue(value)
        return this
    }
}