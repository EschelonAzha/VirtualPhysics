package symmetrical.cosmic._physics._subatomic.matter.beta

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair


class BetaMinus() : LeptonPair() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(BetaMinus::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun decay(baryon: Baryon) : Up {
        var down      : Down = baryon.get(1) as Down

        var electron: Electron = Electron()
        var antiNeutrino: AntiNeutrino = AntiNeutrino()

        electron.setValue(down.red())
        antiNeutrino.setValue(baryon)

        setElectron(electron)
        setAntiNeutrino(antiNeutrino)

        return Up()
    }
    fun getAntiNeutrino() : AntiNeutrino {
        return leptons[1] as AntiNeutrino
    }
    fun getElectron() : Electron {
        return leptons[0] as Electron
    }
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : BetaMinus {
        this.leptons[1] = antiNeutrino as Particle
        return this
    }
    private fun setElectron(electron: Electron) : BetaMinus {
        this.leptons[0] = electron as Particle
        return this
    }
}