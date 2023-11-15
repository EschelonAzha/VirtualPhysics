package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class MinusPion(private val entanglement: QuantumEntanglement = QuantumEntanglement()) : Hadron(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
        super.i(2);
        this.set(0, Down())
        this.set(1, AntiUp())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(MinusPion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }this
}