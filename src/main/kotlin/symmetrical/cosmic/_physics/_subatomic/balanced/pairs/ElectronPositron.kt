package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion


//class ElectronPositron<PlusPion> : LeptonPair {
class ElectronPositron : LeptonPair {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    constructor() {

    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ElectronPositron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
//    fun decay(pion: PlusPion) : ElectronPositron<PlusPion> {
//        return this
//    }
    fun decay(pion: PlusPion) : ElectronPositron {
        return this
    }

    fun getElectron() : Electron {
        return leptons[0] as Electron
    }
    fun getPositron() : Positron {
        return leptons[1] as Positron
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
        this.leptons[0] = electron as Particle
        return this
    }
    private fun setPositron(positron: Positron) : ElectronPositron {
        this.leptons[1] = positron  as Particle
        return this
    }

}