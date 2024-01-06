package symmetrical.cosmic.physics.subatomic.matter.beta

import symmetrical.cosmic.physics.subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_beta.AntiBetaMinus
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Beta_decay
 */
class BetaMinus(
    private val matter: IMatter = Matter(BetaMinus::class, AntiBetaMinus::class),
) : LeptonPair(),
    IMatter by matter
{
    constructor() : this(
        Matter(BetaMinus::class, AntiBetaMinus::class),
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
        return matter.getClassId()
    }
    fun getElectron() : Electron {
        return _lepton as Electron
    }
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : BetaMinus {
        this._antiLepton = antiNeutrino
        return this
    }
    private fun setElectron(electron: Electron) : BetaMinus {
        this._lepton = electron
        return this
    }
}