package symmetrical.cosmic._physics.atomic.atoms.states.doubles

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom


class QDouble() : Atom() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    init {
        setDouble(0.0)
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(QDouble::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun red() : Double {
        return nucleons.getValueProton().red() as Double
    }
    override fun getElectronWavelength() : Double {
        return super.getElectronWavelength() as Double
    }
    fun setDouble(value:Double) : QDouble {
        setQuarkValue(value)
        return this
    }
}