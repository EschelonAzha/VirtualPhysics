package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Time(private val field:QuantumField=QuantumField()) : IQuantumField by field {

    fun getField() : Field {
        return field.getField()
    }

    fun time() : Any? {
        return field.getValue()
    }

    fun setTime(value:Any?) : Any? {
        return setValue(value)
    }

}