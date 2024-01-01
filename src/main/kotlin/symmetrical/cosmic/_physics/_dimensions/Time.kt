package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuasiParticle
import symmetrical.cosmic._physics._subatomic.luminescent.QuasiParticle
/*
https://en.wikipedia.org/wiki/Time_in_physics
 */
class Time(private val field:QuasiParticle=QuasiParticle()) : IQuasiParticle by field {

    override fun absorb(photon:Photon) : Photon {
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
    fun setTime(content:Any?) : Any? {
        return setContent(content)
    }
    fun time() : Any? {
        return field.getContent()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Time::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}