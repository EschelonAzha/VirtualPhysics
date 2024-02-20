package symmetrical.physics.atomic.atoms.nucleons
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.dictionary.absorber.Absorber
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.hadrons.baryons.Neutron
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton


// For more information visit:  https://en.wikipedia.org/wiki/Nucleon


class Nucleons(
    private val matterAntiMatter : IMatterAntiMatter = MatterAntiMatter().with(Nucleons::class),
    private var _protons         : Protons  = Protons(),
    private var neutrons         : Neutrons = Neutrons(),

    ) :
        IMatterAntiMatter by matterAntiMatter,
        IProtons by _protons,
        INeutrons by neutrons,
        INucleons,
        IEmitter
{
    private lateinit var p_atom: Atom

    init {
        setNucleons(this)
    }


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = _protons.absorb(remainder)
        remainder = neutrons.absorb(remainder)

        setNucleons(this)

        return remainder
    }

    override fun betaPlusDecay(content:Any?) : Atom {
        betaPlusDecay()
        _protons.getProton(ValueProton::class).getValueQuark().setContent(content)

        return p_atom
    }

    override fun betaMinusDecay() : Atom {
        val proton      : Proton = getProton(ValueProton::class)
        val protonDown  : Down      = proton.getValueQuark()
        val space       : IParticle = protonDown.getSpace().getSpace()  ?: return p_atom
        val neutronDown :Down       = space as Down
        neutronDown.getSpace().setSpace(null)
        neutrons.remove(neutronDown.getHadron())
        proton.set(0, neutronDown)

        return p_atom
    }
    override fun betaPlusDecay() : Atom {
        val protonDown  :Down       = getProton(ValueProton::class).getValueQuark()
        val neutronDown :Down       = cloneQuark(protonDown)
        val neutron     : Neutron   = Neutron()
        neutron.set(2, neutronDown)
        crossLink(protonDown, neutronDown)
        neutrons.add(neutron)
        return p_atom
    }
    private fun betaPlusDecayPlaceholder() : Nucleons {    // Placeholder for future work
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
        return this
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    fun getAtom() : Atom {
        return this.p_atom
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    override fun getNeutrons() : Neutrons {
        return neutrons
    }

    override fun getProtons() : Protons {
        return _protons
    }

    override fun setAtom(atom: Atom) : Atom {
        this.p_atom = atom
        return atom
    }
    final override fun setNucleons(nucleons:Nucleons) : Nucleons {
        neutrons.setNucleons(nucleons)
        _protons.setNucleons(nucleons)
        return nucleons
    }

    private fun cloneQuark(down:Quark) : Down {

        val emission: Photon = down.emit()
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