package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._dimensions.Dimensions
import symmetrical.cosmic._physics._subatomic.anti_matter.AntiParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import kotlin.reflect.KClass


open class Particle(
    private val antiMatter: IAntiMatter = AntiMatter(Particle::class, AntiParticle::class),
) :
    IAntiMatter by antiMatter,
    IParticle,
    Emitter
{
    constructor() : this(
        AntiMatter(Particle::class, AntiParticle::class),
    )
    object Static {
        const val UNIQUE_ID_LENGTH = 1
    }
    private var uniqueId = ""
    private lateinit var self : IParticle

    private   val dimensions   :Dimensions   = Dimensions()
    protected var fundamentals :Fundamentals = Fundamentals()



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        val (uniqueId, remainder) = Photons.parse(Static.UNIQUE_ID_LENGTH, photon.propagate().radiate())
        this.uniqueId = uniqueId
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val base52Lth = Base52.toFixedBase52(Static.UNIQUE_ID_LENGTH, uniqueId.length)
        return antiMatter.getClassId()+base52Lth+uniqueId
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId = Keys.getUniqueId()
        return getSelf()
    }


    override fun getIlluminations() : IParticleBeam {
        return antiMatter.getIlluminations()
    }

    override fun getSelf() : IParticle {
        if (::self.isInitialized)
            return self
        else return this
    }

    override fun getUniqueId(): String {
        return uniqueId
    }

    override fun setSelf(self: IParticle) : IParticle {
        this.self = self
        return getSelf()
    }
    fun setUniqueId(id:String) : IParticle {
        this.uniqueId = id
        return getSelf()
    }

}