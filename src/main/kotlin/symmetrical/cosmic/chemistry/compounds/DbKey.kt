package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class DbKey(private val entanglement: QuantumEntanglement= QuantumEntanglement()) : Compound(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()){

    }

    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
}