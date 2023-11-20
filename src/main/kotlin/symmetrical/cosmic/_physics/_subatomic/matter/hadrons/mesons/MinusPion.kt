package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class MinusPion(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) : Hadron(entanglement),
    IQuantumEntanglement by entanglement
{

    constructor() : this(
        QuantumEntanglement()
    ) init {
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