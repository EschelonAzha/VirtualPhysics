package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Temperature : IEmitter {


    private var field      : QuantumField = QuantumField()

    fun isNull() : Boolean {
        return field.isNull()
    }

    override fun absorb(photon: Photon) : Photon {
        return field.absorb(photon)
    }

    override fun emit() : Photon {
        return field.emit()
    }

    fun getField() : Field {
        return field.getField()
    }
    fun getValue() : Any? {
        return getField().getValue()
    }
    private fun radiate() : String {
        return field.radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Temperature::class)
    }

    public fun getClassId() : String {
        return getLocalClassId()
    }

    fun temperature() : Any? {
        return field.getValue()
    }

    fun setField(field: Field) : Temperature {
        this.field.setField(field)
        return this
    }

    fun setTemperature(value:Any?) : Any? {
        return field.getField().setValue(value)
    }

    override fun toString() : String {
        return field.getField().toString()
    }
    fun isChange(value:Any?) : Boolean {
        return field.isChange(value)
    }

}