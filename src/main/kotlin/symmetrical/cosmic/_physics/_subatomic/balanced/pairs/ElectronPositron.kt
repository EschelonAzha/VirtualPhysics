package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


//class ElectronPositron<PlusPion> : LeptonPair {
class ElectronPositron(
    private val antiMatter: IAntiMatter = AntiMatter(ElectronPositron::class),
) : LeptonPair(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(ElectronPositron::class),
    )

    constructor(lepton: Lepton, antiLepton: AntiLepton) : this() {
        i(lepton, antiLepton)
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
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