package symmetrical.cosmic._physics._subatomic.anti_matter.anti_beta

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.leptons.Neutrino
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


class AntiBetaPlus() : LeptonPair() {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiBetaPlus::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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

        positron.setValue(up.red())
        neutrino.setValue((proton.get(2)as Quark).red())

        setPositron(positron)
        setNeutrino(neutrino)

        return Down()
    }
    fun getNeutrino() : Neutrino {
        return leptons[1] as Neutrino
    }
    fun getPositron() : Positron {
        return leptons[0] as Positron
    }
    private fun setNeutrino(neutrino: Neutrino) : AntiBetaPlus {
        this.leptons[1] = neutrino  as Particle
        return this
    }
    private fun setPositron(positron: Positron) : AntiBetaPlus {
        this.leptons[0] = positron  as Particle
        return this
    }

}