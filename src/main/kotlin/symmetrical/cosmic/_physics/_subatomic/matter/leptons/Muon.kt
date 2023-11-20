package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Muon(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Lepton(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Muon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Muon {
        super.i()
        return this
    }
}