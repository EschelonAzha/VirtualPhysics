package symmetrical.cosmic._physics._subatomic.fermions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

class Fermion : IFermion {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    var self:Any? = null

    override fun getAbsorberId() : String {
        return Absorber.getClassId(getKClass())
    }

//    override fun getClassId() : String {
//        return Absorber.getClassId(getKClass())
//    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }

    override fun setKClass(kClass: KClass<*>) : IFermion {
        return this
    }
    override fun setSelf(self: Particle) : Fermion {
        this.self = self
        return this
    }

    private  fun getKClass() : KClass<*> {
        if (self == null) {
            return this::class
        }
        return (self as Particle)::class
    }
}