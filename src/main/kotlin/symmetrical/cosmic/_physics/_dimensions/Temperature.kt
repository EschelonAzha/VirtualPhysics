package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Temperature  (private val field:QuantumField=QuantumField()) : IQuantumField by field {

    fun i() : Temperature {
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
    fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }
    fun setTemperature(value:Any?) : Any? {
        return setContent(value)
    }
    fun temperature() : Any? {
        return field.getContent()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Temperature::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }
}