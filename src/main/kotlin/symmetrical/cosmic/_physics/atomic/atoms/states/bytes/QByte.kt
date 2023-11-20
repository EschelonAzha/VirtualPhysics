package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class QByte(
    private val fermion: QuantumEntanglement = QuantumEntanglement()
) : Atom(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    ) init {
        setByte(" ".toByte())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QByte::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Byte {
        return nucleons.getValueProton().red() as Byte
    }
    fun setByte(value:Byte) : QByte {
        setQuarkValue(value)
        return this
    }
}