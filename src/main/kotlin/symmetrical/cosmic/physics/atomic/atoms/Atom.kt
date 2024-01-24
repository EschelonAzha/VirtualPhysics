package symmetrical.cosmic.physics.atomic.atoms

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

import symmetrical.cosmic.physics.subatomic.bosons.IEmitter
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic.physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic.physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic.physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.dictionary.protons.ValueProton
import symmetrical.cosmic.physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Atom
 */

open class Atom(
    private   val matterAntiMatter  : IMatterAntiMatter     = MatterAntiMatter(Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var _nucleons         : Nucleons              = Nucleons()

) : Particle(),
    IMatterAntiMatter   by matterAntiMatter,
    IOrbitals           by orbitals,
    INucleons           by _nucleons,
    Element,
    IEmitter,
    IAtom
{
    companion object {
        fun content(atom: Atom) : Any? {
            return Companion.content(atom.getProton(ValueProton::class))
        }
        fun content(atom: Atom, classType: KClass<*>) : Any? {
            return Companion.content(atom.getProton(classType))
        }
        fun content(proton: Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField().getContent()
        }
        fun field(atom: Atom) : Field {
            return Companion.field(atom.getProton(ValueProton::class))
        }
        fun field(atom: Atom, classType: KClass<*>) : Field {
            return Companion.field(atom.getProton(classType))
        }
        fun field(proton: Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField()
        }
        fun format(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(Companion.field(atom))
        }
    }
    init {
        setAtom(this)
        this.orbitals.setAtom(this)
        this._nucleons.setAtom(this)
    }

    open fun with(content:Any?) : Atom {
        Quark.value(this).setWavelength(content)
        return this
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

    fun accept(valueQuark: Down, zBoson: ZBoson) : Atom {
        valueQuark.getWavelength().setContent(zBoson.getNewValue())
        zBoson.setAccepted(true)
        return this
    }
    open fun capacitanceChange(me: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return zBoson
    }
    fun capacitor_(atom: Atom) : Atom {
        capacitor(atom);
        return atom
    }
    fun _capacitor(atom: Atom) : Atom {
        capacitor(atom);
        return this
    }
    fun conductor_(atom: Atom, autoFlow:Boolean=true) : Atom {
        conductor(atom, autoFlow);
        return atom
    }
    fun _conductor(atom: Atom, autoFlow:Boolean=true) : Atom {
        conductor(atom, autoFlow);
        return this
    }
    fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit {
        diode(atom, autoFlow)
        atom.diode(this, autoFlow)
    }
    fun capacitor(atom: Atom) : Unit {
        val me : Proton = getCurrentValueProton()
        val you: Proton = atom.getCurrentValueProton()

        me.ionicBond(you)
    }
    fun diode_(atom: Atom, autoFlow:Boolean=true) : Atom {
        diode(atom, autoFlow)
        return atom
    }
    fun _diode(atom: Atom, autoFlow:Boolean=true) : Atom {
        diode(atom, autoFlow)
        return this
    }
    fun diode(atom: Atom, autoFlow:Boolean=true) : Unit {
        val me : Proton = getCurrentValueProton()
        val you: Proton = atom.getCurrentValueProton()

        me.covalentBond(you, autoFlow)
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
    fun getCurrentValue() : Any? {
        return _nucleons.getProtons().getProton(ValueProton::class)
    }
    private fun getCurrentValueProton() : Proton {
        return getProtons().getProton(ValueProton::class)
    }
    fun getElectron(pos:Int) : Electron {
        return orbitals.get(pos) as Electron
    }
    fun getField() : Field {
        return Companion.field(this)
    }
    fun getField(proton:KClass<*>) : Field {
        return Companion.field(this, proton)
    }
    fun getProtons() : Protons {
        return _nucleons.getProtons()
    }
    fun reject(reasonCode:Int, reason:String, boson: ZBoson) : Atom {
        boson.setAccepted(false)
        boson.setReasonCode(reasonCode)
        boson.setReason(reason)
        return this;
    }
    final override fun setAtom(atom: Atom) : Atom {
        orbitals.setAtom(this)
        _nucleons.setAtom(this)
        return this
    }
    fun setContent(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().setCurrentValue(
            ZBoson().i(Field().with(value), constructing)).decay()
    }
    open fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        accept(valueQuark, zBoson)
        return zBoson
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Atom")
        }
        val classId :String = matterAntiMatter.getClassId()
        val particle:String = super.emit().radiate()
        val orbitals:String = orbitals.emit().radiate()
        val nucleons:String = _nucleons.emit().radiate()

        return classId+particle+orbitals+nucleons
    }
}