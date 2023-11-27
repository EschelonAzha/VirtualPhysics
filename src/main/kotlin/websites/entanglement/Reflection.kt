package websites.entanglement

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom

class Reflection : ParticleBeam {
    constructor() {

        val atom: Atom = Atom().createUniqueId() as Atom
        val emission = (atom as Atom).emit()

        val (clone, _) = Absorber.materialize(emission)

        val uniqueId = (clone as Atom).getUniqueId()

    }
}