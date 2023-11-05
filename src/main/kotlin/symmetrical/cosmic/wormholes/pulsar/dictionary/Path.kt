package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule


class Path : Molecule {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() : this("") {

    }
    constructor(value:String) {
        var tokens = value.split("/")
        for (i in 1 until tokens.size) {
            if (tokens[i]!= "")
                add(QString(tokens[i]))
        }
        shrink()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Path::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}