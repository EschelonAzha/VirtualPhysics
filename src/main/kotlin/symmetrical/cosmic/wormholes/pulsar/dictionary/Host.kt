package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


class Host(private val entanglement:IQuantumEntanglement=QuantumEntanglement()) : KeyValue(), IQuantumEntanglement by entanglement {


    constructor() : this(QuantumEntanglement()) {

    }
    constructor(key: QString, value: QString) : this() {
        add(key)
        add(value)
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Host::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}