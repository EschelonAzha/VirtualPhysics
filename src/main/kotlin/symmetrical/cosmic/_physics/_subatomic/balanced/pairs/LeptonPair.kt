package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class LeptonPair(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Particle(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    public lateinit var lepton     : Lepton
    public lateinit var antiLepton : AntiLepton


//    constructor(lepton:Lepton, antiLepton:AntiLepton) {
//        i(lepton, antiLepton)
//    }

    fun i(lepton:Lepton, antiLepton:AntiLepton) : LeptonPair {
        this.lepton     = lepton;
        this.antiLepton = antiLepton
        return this
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(LeptonPair::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}