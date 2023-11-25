package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


class Nucleons(
    private val fermion     : ILuminescent = Luminescent(Nucleons::class),
    private var protons     :Protons                = Protons(),
    private var neutrons    :Neutrons               = Neutrons(),

    ) :
        ILuminescent by fermion,
        IProtons             by protons,
        INeutrons            by neutrons,
        INucleons,
        Emitter
{

    constructor() : this(
        Luminescent(Nucleons::class),
        Protons(),
        Neutrons()
    )   init {
        setNucleons(this)
    }

    private lateinit var __atom: Atom




    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        var (protons, remainderProtons) = Absorber.materialize(photon.propagate())
        var (neutrons, remainder)       = Absorber.materialize(remainderProtons)
        this.protons    = protons as Protons
        this.neutrons   = neutrons as Neutrons
        this.protons.setNucleons(this)
        this.neutrons.setNucleons(this)

        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+this.protons.emit().radiate()+this.neutrons.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }

    fun getAtom() : Atom {
        return this.__atom
    }
    fun getProtons() : Protons {
        return protons
    }

    override fun setAtom(atom:Atom) : Atom {
        this.__atom = atom
        return atom
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        neutrons.setNucleons(nucleons)
        protons.setNucleons(nucleons)
        return nucleons
    }
    override fun wind(purpose:String) : Nucleons {

        var pos = Protons.Static.VALUE_PROTON

        var (neutron, betaPlus) = (protons.removeAt(pos) as Proton).betaPlusDecay()
        var proton              = Baryon().Neutron().absorb(betaPlus)

        neutrons.add(neutron)
        protons.add(proton)
        (proton.get(0) as Quark).gluon.color = (neutron.get(0) as Quark).gluon.color.clone() as Color

        NeutralUpPion(proton, neutron)  // exert Nuclear force

        return this
    }
}