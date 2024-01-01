package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
/*
https://en.wikipedia.org/wiki/Neutron
 */
class Neutrons(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Neutrons::class, Neutrons::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    INeutrons
{
    constructor()  : this(
        MatterAntiMatter(Neutrons::class, Neutrons::class),
    )

    lateinit var p_nucleons:Nucleons

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Neutron).setNeutrons(this)
        }
        return remainder
    }
    override fun addNeutron(neutron: Neutron) : Neutron {
        add(neutron)
        return neutron
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun findNeutron(purpose:String) : Int {
        var i=0;
        while (i<size()) {
            val baryon = get(i) as Proton
            if ((baryon.get(2) as Quark).red() == purpose) {
                return i
            }
            i++
        }
        return -1
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getNeutron(pos:Int) : Neutron {
        return get(pos) as Neutron
    }
    override fun getNeutron(purpose:String) : Neutron {
        var pos = findNeutron(purpose)

        if (pos!=-1)
            return getNeutron(pos) as Neutron

        var neutron = Neutron()
        neutron.setPurpose(purpose)
        addNeutron(neutron)
        return neutron
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        this.p_nucleons = nucleons
        return nucleons
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}