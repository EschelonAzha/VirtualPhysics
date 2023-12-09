package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.MatterAntiMatter


//class ElectronPositron<PlusPion> : LeptonPair {
class ElectronPositron(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(ElectronPositron::class, ElectronPositron::class),
) : LeptonPair(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(ElectronPositron::class, ElectronPositron::class),
    )

    constructor(lepton: Lepton, antiLepton: AntiLepton) : this() {
        i(lepton, antiLepton)
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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