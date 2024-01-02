package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
/*
https://en.wikipedia.org/wiki/Nucleon
 */

class Nucleons(
    private val matterAntiMatter :IMatterAntiMatter      = MatterAntiMatter(Nucleons::class, Nucleons::class),
    private var _protons         :Protons                = Protons(),
    private var neutrons         :Neutrons               = Neutrons(),

    ) :
        IMatterAntiMatter    by matterAntiMatter,
        IProtons             by _protons,
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

    private lateinit var p_atom: Atom


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = _protons.absorb(remainder)
        remainder = neutrons.absorb(remainder)

        this._protons.setNucleons(this)
        this.neutrons.setNucleons(this)

        return remainder
    }

    override fun betaPlusDecay(content:Any?) : Nucleons {
        betaPlusDecay()
        _protons.getProton(ValueProton::class).getValueQuark().setContent(content)

        return this
    }

    override fun betaMinusDecay() : Nucleons {
        val proton      :Proton     = getProton(ValueProton::class)
        val protonDown  :Down       = proton.getValueQuark()
        val space       :IParticle  = protonDown.getSpace().getSpace()  ?: return this
        val neutronDown :Down       = space as Down
        neutronDown.getSpace().setSpace(null)
        neutrons.remove(neutronDown.getBaryon())
        proton.set(0, neutronDown)

        return this
    }
    override fun betaPlusDecay() : Nucleons {
        val protonDown  :Down       = getProton(ValueProton::class).getValueQuark()
        val neutronDown :Down       = cloneQuark(protonDown)
        val neutron     :Neutron    = Neutron()
        neutron.set(2, neutronDown)
        crossLink(protonDown, neutronDown)
        neutrons.add(neutron)
        return this
    }
//    private fun betaPlusDecayx() : Nucleons {
//        val pos = _protons.getProton(ValueProton::class)
//
//        var (neutron, betaPlus) = (_protons.removeAt(pos) as Proton).betaPlusDecay()
//        var proton              = Baryon().Neutron().absorb(betaPlus)
//
//        neutrons.add(neutron)
//        _protons.add(proton)
//        (proton.get(0) as Quark).gluon.color = (neutron.get(0) as Quark).gluon.color.clone() as Color
//
//        NeutralUpPion(proton, neutron)  // exert Nuclear force
//
//        return this
//    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun getAtom() : Atom {
        return this.p_atom
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun getProtons() : Protons {
        return _protons
    }

    override fun setAtom(atom:Atom) : Atom {
        this.p_atom = atom
        return atom
    }
    override fun setNucleons(nucleons:Nucleons) : Nucleons {
        neutrons.setNucleons(nucleons)
        _protons.setNucleons(nucleons)
        return nucleons
    }

    private fun cloneQuark(down:Quark) : Down {

        val emission:Photon = down.emit()
        val (clone, _) = Absorber.materialize(emission)
        return clone as Down
    }
    private fun crossLink(quark1:Quark, quark2:Quark) : Unit {
        quark1.getSpace().setSpace(quark2)
        quark2.getSpace().setSpace(quark1)
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Nucleons")
        }
        val classId :String = matterAntiMatter.getClassId()
        val protons :String = _protons.emit().radiate()
        val neutrons:String = neutrons.emit().radiate()
        return classId+protons+neutrons
    }
}