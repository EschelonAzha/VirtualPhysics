package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.spatial.IParticleBeam
import kotlin.reflect.KClass

class Luminescent : ILuminescent {
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
    override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

    override fun setKClass(kClass: KClass<*>) : ILuminescent {
        this.kClass = kClass
        return this
    }


    private fun getKClass() : KClass<*> {
        if (::kClass.isInitialized)
            return kClass
        return Luminescent::class
    }

}