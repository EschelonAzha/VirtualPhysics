package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Neutrons(
    private val antiMatter: IAntiMatter = AntiMatter(Neutrons::class),
) : ParticleBeam(),
    IAntiMatter by antiMatter,
    INeutrons
{
    constructor()  : this(
        AntiMatter(Neutrons::class),
    )


    lateinit var __nucleons:Nucleons




    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        clear()
        val remainder = super.absorb(photon.propagate())
        shrink()
        for (i in 0 until size()) {
            (get(i) as Neutron).setNeutrons(this)
        }
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun addNeutron(neutron: Neutron) : Neutron {
        add(neutron)
        return neutron
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
        this.__nucleons = nucleons
        return nucleons
    }
}