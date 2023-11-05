package symmetrical.cosmic._physics.atomic.atoms.states.vectors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.IBeam
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom

open class QMass() : Atom() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        setMass(Beam(0))
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(QMass::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : IBeam {
        return nucleons.getValueProton().red() as IBeam
    }
    fun setMass(value: IBeam) : QMass {
        setQuarkValue(value)
        return this
    }
}