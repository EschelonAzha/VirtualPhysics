package symmetrical.cosmic.physics.subatomic.balanced.pairs

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Pair_production
 */
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
        return _lepton as Electron
    }
    fun getPositron() : Positron {
        return _antiLepton as Positron
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
        this._lepton = electron
        return this
    }
    private fun setPositron(positron: Positron) : ElectronPositron {
        this._antiLepton = positron
        return this
    }

}