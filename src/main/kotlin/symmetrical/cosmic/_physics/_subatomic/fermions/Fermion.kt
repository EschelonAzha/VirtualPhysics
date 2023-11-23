package symmetrical.cosmic._physics._subatomic.fermions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

class Fermion : IFermion {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    private lateinit var kClass:KClass<*>

    constructor(kClass:KClass<*>) {
        setKClass(kClass)

    }

    override fun check(photon: Photon) : Unit {
        val classId = getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }
    override fun getClassId() : String {
        return Absorber.getClassId(getKClass())
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }

    override fun setKClass(kClass: KClass<*>) : IFermion {
        this.kClass = kClass
        return this
    }


    private fun getKClass() : KClass<*> {
        if (::kClass.isInitialized)
            return kClass
        return Fermion::class
    }

}