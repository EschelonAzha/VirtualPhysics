package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_mesons.AntiNeutralUpPion
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiUp
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class NeutralUpPion(
    private val antiMatter: IAntiMatter = AntiMatter(NeutralUpPion::class, AntiNeutralUpPion::class),
) : Hadron(),
    IAntiMatter by antiMatter
{
    // The Neutral up Pion binds proton and neutron together
    // by binding the pointers together
    constructor() : this(
        AntiMatter(NeutralUpPion::class, AntiNeutralUpPion::class),
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
        return antiMatter.getClassId()
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