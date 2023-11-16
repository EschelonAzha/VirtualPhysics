package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.gluons.Blue_AntiBlue
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// PHOTON VALUE
open class Blue(private val entanglement: QuantumEntanglement = QuantumEntanglement()): Color(), IQuantumEntanglement by entanglement {// Double

    init {
        color = BLUE
    }
    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Blue::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Blue {
        super.i()
        return this
    }
    override fun clone() : Blue {
        var result      = Blue()
        result.setValue(_value)
        return result
    }
    fun blue(charge: Gluon) : Blue_AntiBlue {
        var gluon = Blue_AntiBlue()
        gluon.color.setValue    (QCD().blue(charge.getAntiValue()))
        gluon.antiColor.setValue(charge.getAntiValue())

        return gluon
    }

}