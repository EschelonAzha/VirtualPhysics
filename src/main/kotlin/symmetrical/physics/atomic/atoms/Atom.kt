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
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.nucleons.INucleons
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.matter.leptons.Electron
import symmetrical.electronics.Electronics
import symmetrical.electronics.IElectronics
import symmetrical.physics.subatomic.balanced.values.ITypeConverter
import symmetrical.physics.subatomic.balanced.values.TypeConverter
import symmetrical.physics.subatomic.matter.quarks.Up
import kotlin.reflect.KClass

// For more information visit:  https://en.wikipedia.org/wiki/Atom


open class Atom(
    private   val matterAntiMatter  : IMatterAntiMatter     = MatterAntiMatter().with(Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var _nucleons         : Nucleons              = Nucleons(),
    public    val electronics       : Electronics           = Electronics(),
    private   val typeConverter     : ITypeConverter        = TypeConverter()

) : Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals           by orbitals,
    INucleons           by _nucleons,
    IElectronics        by electronics,
    ITypeConverter      by typeConverter,
    IEmitter,
    IAtom
{
    init {
        setAtom(this)
    }

    open fun with(content:Any?) : Atom {
        setAtomicValue(content, true)
        return this
    }
    open fun addProtons(protons:Array<Proton>) : Atom {
        for (proton: Proton in protons) {
            _nucleons.addProton(proton)
        }
        return this
    }
    fun accept(valueQuark: Down, zBoson: ZBoson) : Atom {
        valueQuark.getWavelength().setContent(zBoson.getNewValue())
        zBoson.setAccepted(true)
        return this
    }
    open fun capacitanceChange(me: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        return zBoson
    }
    fun format() : String {
        val value:Proton  = getValueProton()
        val format:Quark  = value.getFormatQuark()
        format.mediate(value.getValueQuark(), value.getConstraintsQuark(), ZBoson())
        return format.getWavelength().getField().toString()
    }
    fun getContent() : Any? {
        return getField().getContent()
    }

    fun getElectron(pos:Int) : Electron {
        return orbitals.get(pos) as Electron
    }
    fun getField() : Field {
        return getProton(ValueProton::class).getValueQuark().getWavelength().getField()
    }
    fun getField(protonClass:KClass<*>) : Field {
        val proton : Proton  = getProton(protonClass)
        return proton.getValueQuark().getWavelength().getField()
    }
    open fun getProtonField(kClass: KClass<*>) : Field {
        val proton: Proton = getProton(kClass)
        return proton.getValueQuark().getWavelength().getField()
    }
    open fun getValue() : Field {
        return getProtonField(ValueProton::class)
    }

    override fun getValueElectron() : Electron {
        return orbitals.getValueElectron()
    }
    fun getValueProton() : Proton {
        return getProtons().getProton(ValueProton::class)
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
        electronics.setAtom(this)
        this.typeConverter.setAtom(this)
        return this
    }
    fun setAtomicValue(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().interact(
            ZBoson().with(Field().with(value), constructing)).decay()
    }

    fun setContent(content:Any?) : Any? {
        getField().setContent(content)
        return content
    }
    fun setFormat(format: Up) : Atom {
        getValueProton().setFormatQuark(format)
        return this
    }
    fun setConstraint(constraint:Up) : Atom {
        getValueProton().setConstraintsQuark(constraint)
        return this
    }
    open fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        zBoson.mediate(proton)
        if (!zBoson.isAccepted()) {
            return zBoson
        }
        accept(valueQuark, zBoson)
        return zBoson
    }

    override fun toString() : String {
        return getField().toString()
    }






    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = orbitals.absorb(remainder)
        remainder = _nucleons.absorb(remainder)

        setAtom(this)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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
    // ########################### EMISSIONS ###########################
}