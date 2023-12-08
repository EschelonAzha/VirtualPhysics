package symmetrical.cosmic._physics._subatomic.matter.beta

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_beta.AntiBetaMinus
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


class BetaMinus(
    private val matter: IMatter = Matter(BetaMinus::class, AntiBetaMinus::class, true),
) : LeptonPair(),
    IMatter by matter
{
    constructor() : this(
        Matter(BetaMinus::class, AntiBetaMinus::class, true),
    )

    override fun getClassId() : String {
        return matter.getClassId()
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
        return antiLepton as AntiNeutrino
    }
    fun getElectron() : Electron {
        return lepton as Electron
    }
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : BetaMinus {
        this.antiLepton = antiNeutrino
        return this
    }
    private fun setElectron(electron: Electron) : BetaMinus {
        this.lepton = electron
        return this
    }
}