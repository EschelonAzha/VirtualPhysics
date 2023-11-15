package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Green_AntiGreen
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// FORMATTED VALUE
open class Green (private val entanglement: QuantumEntanglement = QuantumEntanglement()): Color(), IQuantumEntanglement by entanglement {  // Int

    init {
        color = GREEN
    }
    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Green::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Green {
        super.i()
        return this
    }
    override fun clone() : Green {
        var result      = Green()
        result.setValue(_value)
        return result
    }
    open fun green(charge: Gluon) : Green_AntiGreen {
        var gluon               = Green_AntiGreen()
        gluon.antiColor.setValue(charge.getAntiValue())
        gluon.color.setValue    (format(charge.getAntiValue()))
        return gluon
    }

    open fun format(redValue:Any?) : Any? {
        return QCD().green(redValue)
    }
}