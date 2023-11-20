package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class PlusPion(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Hadron(),
    IQuantumEntanglement by fermion
{
    // The plus pion binds Protons together by carrying the color
    // charge of one to the other
    constructor() : this(
        QuantumEntanglement()
    ) init {
        super.i(2)
        this.set(0, Up())
        this.set(1, AntiDown())
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(PlusPion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
//    fun decay() : ElectronPositron<PlusPion> {
//        return ElectronPositron<PlusPion>().decay(this)
//    }
    fun decay() : ElectronPositron {
        return ElectronPositron().decay(this)
    }
}