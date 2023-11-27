package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Keys
import symmetrical.cosmic.__transpectors.transpectors.Photons
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import kotlin.reflect.KClass


open class Particle(
    private val luminescent: ILuminescent = Luminescent(Particle::class),
) :
    ILuminescent by luminescent,
    IParticle,
    Emitter
{
    constructor() : this(
        Luminescent(Particle::class),
    )
    object Static {
        var ANTI_MATTER : KClass<*>  = Particle::class

        const val UNIQUE_ID_LENGTH = 1
    }
    private var uniqueId = ""
    private lateinit var self : IParticle



    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        val (uniqueId, remainder) = Photons.parse(Static.UNIQUE_ID_LENGTH, photon.propagate().radiate())
        this.uniqueId = uniqueId
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val base52Lth = Base52.toFixedBase52(Static.UNIQUE_ID_LENGTH, uniqueId.length)
        return luminescent.getClassId()+base52Lth+uniqueId
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    override fun createUniqueId(): IParticle {
        uniqueId = Keys.getUniqueId()
        return getSelf()
    }

    override fun getAntiMatter() : KClass<*> {
        return Static.ANTI_MATTER
    }

    override fun getSelf() : IParticle {
        if (::self.isInitialized)
            return self
        else return this
    }

    override fun getUniqueId(): String {
        return uniqueId
    }

    override fun setAntiMatter(antiMatter:KClass<*>) : IParticle {
        Static.ANTI_MATTER = antiMatter
        return this
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