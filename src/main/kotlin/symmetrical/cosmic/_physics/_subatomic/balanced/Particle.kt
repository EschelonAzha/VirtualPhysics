package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class Particle : IParticle, Emitter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val UNIQUE_ID_LENGTH = 1
    }
    private var uniqueId = ""
    private lateinit var parent : IParticle
    constructor() {

    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        val (uniqueId, remainder) = Photons.parse(Static.UNIQUE_ID_LENGTH, photon.propagate().radiate())
        this.uniqueId = uniqueId
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val base52Lth = Base52.toFixedBase52(Static.UNIQUE_ID_LENGTH, uniqueId.length)
        return getLocalClassId()+base52Lth+uniqueId
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Particle::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId = Keys.getUniqueId()
        return parent
    }

    override fun getUniqueId(): String {
        return uniqueId
    }

    override fun setParent(parent: IParticle) : IParticle {
        this.parent = parent
        return parent
    }
    fun setUniqueId(id:String) : Particle {
        this.uniqueId = id
        return this
    }

}