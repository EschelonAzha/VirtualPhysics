package symmetrical.cosmic._physics.atomic.atoms.states.booleans

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom

class QBoolean() : Atom() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        setBoolean(false)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(QBoolean::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Boolean {
        return nucleons.getValueProton().red() as Boolean
    }
    fun setBoolean(value:Boolean) : QBoolean {
        setQuarkValue(value)
        return this
    }
}