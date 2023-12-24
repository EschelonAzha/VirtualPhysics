package symmetrical.cosmic._physics._subatomic.matter.beta

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_beta.AntiBetaPlus
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.leptons.Neutrino
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter


class BetaPlus(
    private val matter: IMatter = Matter(BetaPlus::class, AntiBetaPlus::class),
) : LeptonPair(),
    IMatter by matter
{
    constructor() : this(
        Matter(BetaPlus::class, AntiBetaPlus::class),
    )


    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun absorb(neutron: Baryon) : Up {
        var down    : Down = neutron.get(1) as Down

        (neutron.get(0)as Quark).gluon.setValue(getPositron().wavelength())
        (neutron.get(2)as Quark).gluon.setValue(getNeutrino().wavelength())

        return Up()
    }

    fun decay(proton: Baryon) : Down {
        var up      : Up = proton.get(0) as Up

        var positron: Positron = Positron()
        var neutrino: Neutrino = Neutrino()

        positron.setWavelength(up.red())
        neutrino.setWavelength((proton.get(2)as Quark).red())

        setPositron(positron)
        setNeutrino(neutrino)

        return Down()
    }
    fun getNeutrino() : Neutrino {
        return lepton as Neutrino
    }
    fun getPositron() : Positron {
        return antiLepton as Positron
    }
    private fun setNeutrino(neutrino: Neutrino) : BetaPlus {
        this.lepton = neutrino
        return this
    }
    private fun setPositron(positron: Positron) : BetaPlus {
        this.antiLepton = positron
        return this
    }

}