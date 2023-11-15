package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class Hydrogen(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : IQuantumEntanglement by entanglement {

    lateinit var atom : Atom

    constructor() : this(QuantumEntanglement()) {

    }
    constructor(atom: Atom) : this(QuantumEntanglement()) {
        this.atom = atom
    }
    fun i(atom: Atom) : Hydrogen {
        this.atom = atom
        atom.setAtomicNumber(1)
        return this
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Hydrogen::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}