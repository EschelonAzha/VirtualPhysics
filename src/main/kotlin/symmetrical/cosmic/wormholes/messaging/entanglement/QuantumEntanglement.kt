package symmetrical.cosmic.wormholes.messaging.entanglement

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.fermion.Fermion
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

class QuantumEntanglement : IQuantumEntanglement {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }


    var self:Any? = null

    override fun setSelf(self: Particle) : QuantumEntanglement {
        this.self = self
        return this
    }
    override fun getAbsorberId() : String {
        return Absorber.getClassId(getKClass())
    }

    override fun getClassId() : String {
        return Absorber.getClassId(getKClass())
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }

    private  fun getKClass() : KClass<*> {
        if (self == null) {
            return this::class
        }
        return (self as Particle)::class
    }
}