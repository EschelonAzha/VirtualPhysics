package symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralUpPion
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.hadrons.Hadron

/*
https://en.wikipedia.org/wiki/Pion
 */
open class NeutralUpPion(
    private val matter: IMatter = Matter(NeutralUpPion::class, AntiNeutralUpPion::class),
) : Hadron(),
    IMatter by matter
{
    // The Neutral up Pion binds proton and neutron together
    // by binding the pointers together
    constructor() : this(
        Matter(NeutralUpPion::class, AntiNeutralUpPion::class),
    )
    constructor(proton: Baryon, neutron: Baryon) : this() {
        super.i(2)
        this.add(Up())
        this.add(AntiUp())

        val up0 = get(0) as Up
        val up1 = get(1) as AntiUp
        up0.z(Quark.Args(proton))
        up1.z(AntiQuark.Args(neutron))

        nuclearForce()
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }



    fun getNeutron() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
    fun getProton() : Baryon {
        return (get(1) as Quark).red() as Baryon
    }
    fun nuclearForce() : NeutralUpPion {
        val protonQ1 = getProton().get(1) as Quark
        val neutronQ1 = getNeutron().get(1) as Quark

        protonQ1.z(Quark.Args(getNeutron()))
        neutronQ1.z(Quark.Args(getProton()))
        return this
    }
}