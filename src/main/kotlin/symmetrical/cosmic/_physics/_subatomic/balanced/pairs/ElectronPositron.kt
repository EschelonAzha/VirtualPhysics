package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


//class ElectronPositron<PlusPion> : LeptonPair {
class ElectronPositron(
    private val fermion: IFermion = Fermion(ElectronPositron::class),
) : LeptonPair(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(ElectronPositron::class),
    )

    constructor(lepton: Lepton, antiLepton: AntiLepton) : this() {
        i(lepton, antiLepton)
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
//    fun decay(pion: PlusPion) : ElectronPositron<PlusPion> {
//        return this
//    }
    fun decay(pion: PlusPion) : ElectronPositron {
        return this
    }

    fun getElectron() : Electron {
        return lepton as Electron
    }
    fun getPositron() : Positron {
        return antiLepton as Positron
    }
//    private fun setElectron(electron: Electron) : ElectronPositron<PlusPion> {
//        this.leptons[0] = electron
//        return this
//    }
//    private fun setPositron(positron: Positron) : ElectronPositron<PlusPion> {
//        this.leptons[1] = positron
//        return this
//    }
    private fun setElectron(electron: Electron) : ElectronPositron {
        this.lepton = electron
        return this
    }
    private fun setPositron(positron: Positron) : ElectronPositron {
        this.antiLepton = positron
        return this
    }

}