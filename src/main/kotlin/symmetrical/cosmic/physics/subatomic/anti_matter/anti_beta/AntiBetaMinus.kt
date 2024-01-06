package symmetrical.cosmic.physics.subatomic.anti_matter.anti_beta

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic.physics.subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.luminescent.IAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.AntiMatter
import symmetrical.cosmic.physics.subatomic.matter.beta.BetaMinus
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Beta_decay
 */
class AntiBetaMinus(
    private val antiMatter: IAntiMatter = AntiMatter(AntiBetaMinus::class, BetaMinus::class),
) : LeptonPair(),
    IAntiMatter by antiMatter

{
    constructor() : this(
        AntiMatter(AntiBetaMinus::class, BetaMinus::class),
    )

    fun decay(baryon: Baryon) : Up {
        var down      : Down = baryon.get(1) as Down

        var electron: Electron = Electron()
        var antiNeutrino: AntiNeutrino = AntiNeutrino()

        electron.setWavelength(down.red())
        antiNeutrino.setWavelength(baryon)

        setElectron(electron)
        setAntiNeutrino(antiNeutrino)

        return Up()
    }
    fun getAntiNeutrino() : AntiNeutrino {
        return _antiLepton as AntiNeutrino
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    fun getElectron() : Electron {
        return _lepton as Electron
    }
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : AntiBetaMinus {
        this._antiLepton =  antiNeutrino
        return this
    }
    private fun setElectron(electron: Electron) : AntiBetaMinus {
        this._lepton = electron
        return this
    }
}