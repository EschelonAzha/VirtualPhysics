package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue


class Host : KeyValue {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    constructor() {

    }
    constructor(key: QString, value: QString) : super(key, value) {
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Host::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}