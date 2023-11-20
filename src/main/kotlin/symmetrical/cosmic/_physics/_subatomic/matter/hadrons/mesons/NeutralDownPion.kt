package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class NeutralDownPion(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Hadron(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    ) init {
        super.i(2)
        this.set(0, Down())
        this.set(1, AntiDown())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(NeutralDownPion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }
}