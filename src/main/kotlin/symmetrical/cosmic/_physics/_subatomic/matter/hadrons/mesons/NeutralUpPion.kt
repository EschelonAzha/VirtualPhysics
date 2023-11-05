package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.quarks.Quark
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon


open class NeutralUpPion : Hadron {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // The Neutral up Pion binds proton and neutron together
    // by binding the pointers together
    constructor() {

    }
    constructor(proton: Baryon, neutron: Baryon)  {
        super.i(2)
        this.add(Up())
        this.add(AntiUp())

        val up0 = get(0) as Up
        val up1 = get(1) as AntiUp
        up0.z(Quark.Args(proton))
        up1.z(Quark.Args(neutron))

        nuclearForce()
    }
    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(NeutralUpPion::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun nuclearForce() : NeutralUpPion {
        val protonQ1 = getProton().get(1) as Quark
        val neutronQ1 = getNeutron().get(1) as Quark

        protonQ1.z(Quark.Args(getNeutron()))
        neutronQ1.z(Quark.Args(getProton()))
        return this
    }

    fun getNeutron() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
    fun getProton() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
}