package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Red_AntiRed
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// ACTUAL VALUE
open class Red(private val entanglement: QuantumEntanglement = QuantumEntanglement()): Color(), IQuantumEntanglement by entanglement {  // Boolean

    init {
        color = RED
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Red::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun clone() : Red {
        var result      = Red()
        result.setValue(_value)
        return result
    }
    fun red(charge: Gluon) : Red_AntiRed {
        var gluon = Red_AntiRed()
        gluon.setValue    (charge.getAntiValue())
        return gluon
    }
}