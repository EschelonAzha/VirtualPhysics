package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton


class Nucleons(
    private val matterAntiMatter :IMatterAntiMatter      = MatterAntiMatter(Nucleons::class, Nucleons::class),
    private var protons          :Protons                = Protons(),
    private var neutrons         :Neutrons               = Neutrons(),

    ) :
        IMatterAntiMatter    by matterAntiMatter,
        IProtons             by protons,
        INeutrons            by neutrons,
        INucleons,
        IEmitter
{

    constructor() : this(
        MatterAntiMatter(Nucleons::class, Nucleons::class),
        Protons(),
        Neutrons()
    )   init {
        setNucleons(this)
    }

    private lateinit var __atom: Atom


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = protons.absorb(remainder)
        remainder = neutrons.absorb(remainder)

        this.protons.setNucleons(this)
        this.neutrons.setNucleons(this)

        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun getAtom() : Atom {
        return this.__atom
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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
        val pos = protons.find(ValueProton::class)

        var (neutron, betaPlus) = (protons.removeAt(pos) as Proton).betaPlusDecay()
        var proton              = Baryon().Neutron().absorb(betaPlus)

        neutrons.add(neutron)
        protons.add(proton)
        (proton.get(0) as Quark).gluon.color = (neutron.get(0) as Quark).gluon.color.clone() as Color

        NeutralUpPion(proton, neutron)  // exert Nuclear force

        return this
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                this.protons.emit().radiate()+
                this.neutrons.emit().radiate()
    }
}