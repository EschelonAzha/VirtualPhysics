package symmetrical.cosmic._physics.atomic.atoms.states.integers

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


// Where do I add Validators?   Are they Neutrons or Protons
class QInt(
    private val fermion: QuantumEntanglement = QuantumEntanglement()
) : Atom(),
    IQuantumEntanglement by fermion
{

    constructor() : this(
        QuantumEntanglement()
    ) init {
        setInt(0)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QInt::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Int {
        return nucleons.getValueProton().red() as Int
    }
    fun setInt(value:Int) : QInt {
        setQuarkValue(value)
        return this
    }
}