package symmetrical.cosmic.chemistry.compounds

import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

class DbKey : Compound {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() : super(QuantumEntanglement()){

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    fun addKey(atom: Atom) : DbKey {
        add(atom)
        return this;
    }
}