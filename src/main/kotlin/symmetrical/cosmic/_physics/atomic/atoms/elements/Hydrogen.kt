package symmetrical.cosmic._physics.atomic.atoms.elements

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom

class Hydrogen {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var atom : Atom

    constructor() {

    }
    constructor(atom: Atom) {
    }
    fun i(atom: Atom) : Hydrogen {
        this.atom = atom
        atom.setAtomicNumber(1)
        return this
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Hydrogen::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
}