package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuasiParticle
import symmetrical.cosmic._physics._subatomic.luminescent.QuasiParticle
/*
https://en.wikipedia.org/wiki/Space
 */
class Space (private val field: QuasiParticle = QuasiParticle()) : IQuasiParticle by field {

    private var space: IParticle? = null   // this may have to change to a Particle UniqueId when emitted

    constructor() : this(
        QuasiParticle()
    )
    fun i() : Space {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon  = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }
    fun getSpace() : IParticle? {
        return space
    }
    fun setSpace(particle:IParticle?) : Any? {
        this.space = particle
        return null
    }
    fun space() : Any? {
        return field.getContent()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Space::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}