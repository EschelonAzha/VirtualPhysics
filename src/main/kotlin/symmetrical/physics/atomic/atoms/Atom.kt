package symmetrical.physics.atomic.atoms

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

import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.physics.atomic.atoms.nucleons.Nucleons
import symmetrical.physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.physics.atomic.atoms.orbitals.Orbitals
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.atomic.atoms.nucleons.Protons
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.nucleons.INucleons
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.leptons.Electron
import symmetrical.electronics.Electronics
import symmetrical.electronics.IElectronics
import kotlin.reflect.KClass

// For more information visit:  https://en.wikipedia.org/wiki/Atom


open class Atom(
    private   val matterAntiMatter  : IMatterAntiMatter = MatterAntiMatter().with(symmetrical.physics.atomic.atoms.Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var _nucleons         : Nucleons              = Nucleons(),
    public    var electronics       : Electronics           = Electronics()

) : symmetrical.physics.subatomic.balanced.Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals           by orbitals,
    symmetrical.physics.atomic.atoms.nucleons.INucleons by _nucleons,
    IElectronics        by electronics,
    IEmitter,
    symmetrical.physics.atomic.atoms.IAtom
{
    init {
        setAtom(this)
        this.orbitals.setAtom(this)
        this._nucleons.setAtom(this)
    }

    open fun with(content:Any?) : symmetrical.physics.atomic.atoms.Atom {
        setContent(content, true)
        return this
    }
    open fun addProtons(protons:Array<symmetrical.physics.subatomic.matter.hadrons.baryons.Proton>) : symmetrical.physics.atomic.atoms.Atom {
        for (proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton in protons) {
            _nucleons.addProton(proton)
        }
        return this
    }



    companion object {
        fun content(atom: symmetrical.physics.atomic.atoms.Atom) : Any? {
            return symmetrical.physics.atomic.atoms.Atom.Companion.content(atom.getProton(ValueProton::class))
        }
        fun content(atom: symmetrical.physics.atomic.atoms.Atom, classType: KClass<*>) : Any? {
            return symmetrical.physics.atomic.atoms.Atom.Companion.content(atom.getProton(classType))
        }
        fun content(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField().getContent()
        }
        fun field(atom: symmetrical.physics.atomic.atoms.Atom) : Field {
            return symmetrical.physics.atomic.atoms.Atom.Companion.field(atom.getProton(ValueProton::class))
        }
        fun field(atom: symmetrical.physics.atomic.atoms.Atom, classType: KClass<*>) : Field {
            return symmetrical.physics.atomic.atoms.Atom.Companion.field(atom.getProton(classType))
        }
        fun field(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField()
        }
        fun format(atom: symmetrical.physics.atomic.atoms.Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(symmetrical.physics.atomic.atoms.Atom.Companion.field(atom))
        }
    }


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = orbitals.absorb(remainder)
        remainder = _nucleons.absorb(remainder)


        setAtom(this)
        return remainder
    }

    fun accept(valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.atomic.atoms.Atom {
        valueQuark.getWavelength().setContent(zBoson.getNewValue())
        zBoson.setAccepted(true)
        return this
    }
    open fun capacitanceChange(me: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        return zBoson
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getContent() : Any? {
        return getField().getContent()
    }

    fun getElectron(pos:Int) : symmetrical.physics.subatomic.matter.leptons.Electron {
        return orbitals.get(pos) as symmetrical.physics.subatomic.matter.leptons.Electron
    }
    fun getField() : Field {
        return symmetrical.physics.atomic.atoms.Atom.Companion.field(this)
    }
    fun getField(proton:KClass<*>) : Field {
        return symmetrical.physics.atomic.atoms.Atom.Companion.field(this, proton)
    }
    fun getValueProton() : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        return getProtons().getProton(ValueProton::class)
    }

    fun reject(reasonCode:Int, reason:String, boson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.atomic.atoms.Atom {
        boson.setAccepted(false)
        boson.setReasonCode(reasonCode)
        boson.setReason(reason)
        return this;
    }
    final override fun setAtom(atom: symmetrical.physics.atomic.atoms.Atom) : symmetrical.physics.atomic.atoms.Atom {
        orbitals.setAtom(this)
        _nucleons.setAtom(this)
        electronics.setAtom(this)
        return this
    }
    fun setContent(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().interact(
            symmetrical.physics.subatomic.matter.bosons.ZBoson().with(Field().with(value), constructing)).decay()
    }
    open fun valueChange(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        accept(valueQuark, zBoson)
        return zBoson
    }

    override fun toString() : String {
        return getField().toString()
    }

    private fun radiate() : String {
        if (symmetrical.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Atom")
        }
        val classId :String = matterAntiMatter.getClassId()
        val particle:String = super.emit().radiate()
        val orbitals:String = orbitals.emit().radiate()
        val nucleons:String = _nucleons.emit().radiate()

        return classId+particle+orbitals+nucleons
    }
}