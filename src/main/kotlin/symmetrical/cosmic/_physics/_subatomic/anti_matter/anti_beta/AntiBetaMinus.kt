package symmetrical.cosmic._physics._subatomic.anti_matter.anti_beta

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiNeutrino
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AntiBetaMinus(
    private val luminescent: ILuminescent = Luminescent(AntiBetaMinus::class),
) : LeptonPair(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AntiBetaMinus::class),
    )


    override fun getClassId() : String {
        return luminescent.getClassId()
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
    private fun setAntiNeutrino(antiNeutrino: AntiNeutrino) : AntiBetaMinus {
        this.antiLepton =  antiNeutrino
        return this
    }
    private fun setElectron(electron: Electron) : AntiBetaMinus {
        this.lepton = electron
        return this
    }
}