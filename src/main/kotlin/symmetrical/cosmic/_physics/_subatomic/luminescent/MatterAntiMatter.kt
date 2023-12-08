package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import kotlin.reflect.KClass

open class MatterAntiMatter: IAntiMatter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    private var positive   : KClass<*>
    private var negative   : KClass<*>

    constructor(positive: KClass<*>, negative: KClass<*>) {
        this.positive = positive
        this.negative = negative;

    }

    //    override fun annihilate() : Photon {
//
//    }
    override fun check(photon: Photon) : Unit {
        val classId = getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }
    override fun getClassId() : String {
        return Absorber.getClassId(this.positive)
    }
    override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

}