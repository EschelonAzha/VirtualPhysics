package symmetrical.cosmic._physics.atomic.atoms.states.bytes

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class QByte(
    private val entanglement: QuantumEntanglement = QuantumEntanglement()
) : Atom(entanglement),
    IQuantumEntanglement by entanglement
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