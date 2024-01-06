package symmetrical.cosmic.physics.subatomic.luminescent

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Annihilation
 */
open class MatterAntiMatter: IMatterAntiMatter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    private var positive   : KClass<*>
    private var negative   : KClass<*>

    constructor(positive: KClass<*>, negative: KClass<*>) {
        this.positive = positive
        this.negative = negative;

    }
    override fun annihilate() : Photon {
        return Photon()
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
        return Absorber.getClassId(this.positive)
    }
    override fun getIlluminations() : IParticleBeam {
        return Illuminations.beam
    }

}