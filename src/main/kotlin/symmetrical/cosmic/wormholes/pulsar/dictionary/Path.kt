package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement


class Path(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) : Molecule(entanglement),
    IQuantumEntanglement by entanglement
{

    constructor() : this("") {

    }
    constructor(value:String) : this(QuantumEntanglement()) {
        var tokens = value.split("/")
        for (i in 1 until tokens.size) {
            if (tokens[i]!= "")
                add(QString(tokens[i]))
        }
        shrink()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Path::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}