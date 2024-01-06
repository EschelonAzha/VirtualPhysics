package symmetrical.cosmic.physics.dimensions

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.luminescent.IQuasiParticle
import symmetrical.cosmic.physics.subatomic.luminescent.QuasiParticle
/*
https://en.wikipedia.org/wiki/Charge_(physics)
 */
class Charge (private val field: QuasiParticle = QuasiParticle()) : IQuasiParticle by field {

    object Static {
        const val PLUS:Byte  = +1
        const val ZERO:Byte  = 0
        const val MINUS:Byte = -1
    }
    constructor() : this(
        QuasiParticle()
    ) {
        setCharge(Static.ZERO)
    }
    fun i() : Charge {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder : Photon = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    fun charge() : Any? {
        return field.getContent()
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
    fun setCharge(content:Any?) : Any? {
        return setContent(content)
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Charge::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}