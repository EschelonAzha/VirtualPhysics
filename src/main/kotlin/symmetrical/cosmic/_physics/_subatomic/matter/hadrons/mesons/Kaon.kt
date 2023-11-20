package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Strange
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class Kaon(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Hadron(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    lateinit var quark      : Strange
    lateinit var antiQuark  : AntiUp

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Kaon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}