package symmetrical.cosmic.physics.atomic.atoms
/*
                 GNU LESSER GENERAL PUBLIC LICENSE
                      Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.


 This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

 0. Additional Definitions.

 As used herein, “this License” refers to version 3 of the GNU Lesser
General Public License, and the “GNU GPL” refers to version 3 of the GNU
General Public License.

 “The Library” refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

 An “Application” is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

 A “Combined Work” is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the “Linked
Version”.

 The “Minimal Corresponding Source” for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

 The “Corresponding Application Code” for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

 1. Exception to Section 3 of the GNU GPL.

 You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

 2. Conveying Modified Versions.

 If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

  a) under this License, provided that you make a good faith effort to
  ensure that, in the event an Application does not supply the
  function or data, the facility still operates, and performs
  whatever part of its purpose remains meaningful, or

  b) under the GNU GPL, with none of the additional permissions of
  this License applicable to that copy.

 3. Object Code Incorporating Material from Library Header Files.

 The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

  a) Give prominent notice with each copy of the object code that the
  Library is used in it and that the Library and its use are
  covered by this License.

  b) Accompany the object code with a copy of the GNU GPL and this license
  document.

 4. Combined Works.

 You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

  a) Give prominent notice with each copy of the Combined Work that
  the Library is used in it and that the Library and its use are
  covered by this License.

  b) Accompany the Combined Work with a copy of the GNU GPL and this license
  document.

  c) For a Combined Work that displays copyright notices during
  execution, include the copyright notice for the Library among
  these notices, as well as a reference directing the user to the
  copies of the GNU GPL and this license document.

  d) Do one of the following:

      0) Convey the Minimal Corresponding Source under the terms of this
      License, and the Corresponding Application Code in a form
      suitable for, and under terms that permit, the user to
      recombine or relink the Application with a modified version of
      the Linked Version to produce a modified Combined Work, in the
      manner specified by section 6 of the GNU GPL for conveying
      Corresponding Source.

      1) Use a suitable shared library mechanism for linking with the
      Library.  A suitable mechanism is one that (a) uses at run time
      a copy of the Library already present on the user’s computer
      system, and (b) will operate properly with a modified version
      of the Library that is interface-compatible with the Linked
      Version.

  e) Provide Installation Information, but only if you would otherwise
  be required to provide such information under section 6 of the
  GNU GPL, and only to the extent that such information is
  necessary to install and execute a modified version of the
  Combined Work produced by recombining or relinking the
  Application with a modified version of the Linked Version. (If
  you use option 4d0, the Installation Information must accompany
  the Minimal Corresponding Source and Corresponding Application
  Code. If you use option 4d1, you must provide the Installation
  Information in the manner specified by section 6 of the GNU GPL
  for conveying Corresponding Source.)

 5. Combined Libraries.

 You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

  a) Accompany the combined library with a copy of the same work based
  on the Library, uncombined with any other library facilities,
  conveyed under the terms of this License.

  b) Give prominent notice with the combined library that part of it
  is a work based on the Library, and explaining where to find the
  accompanying uncombined form of the same work.

 6. Revised Versions of the GNU Lesser General Public License.

 The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

 Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License “or any later version”
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

 If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy’s public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.
*/

import symmetrical.cosmic._physics.subatomic.bosons.IEmitter
import symmetrical.cosmic._physics.subatomic.bosons.Photon
import symmetrical.cosmic._physics.subatomic.matter.quarks.Down
import symmetrical.cosmic._physics.subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic.physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic.physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic.physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics.subatomic.balanced.values.Field
import symmetrical.cosmic._physics.subatomic.luminescent.*
import symmetrical.cosmic._physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic._physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Atom
 */

open class Atom(
    private   val matterAntiMatter  : IMatterAntiMatter = MatterAntiMatter(symmetrical.cosmic.physics.atomic.atoms.Atom::class, symmetrical.cosmic.physics.atomic.atoms.Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var _nucleons         : Nucleons              = Nucleons()

) : symmetrical.cosmic._physics.subatomic.balanced.Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals               by orbitals,
    symmetrical.cosmic.physics.atomic.atoms.nucleons.INucleons by _nucleons,
    symmetrical.cosmic.physics.atomic.atoms.Element,
    IEmitter,
    symmetrical.cosmic.physics.atomic.atoms.IAtom
{
    companion object {
        fun content(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : Any? {
            return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.content(atom.getProton(ValueProton::class))
        }
        fun content(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, kClass: KClass<*>) : Any? {
            return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.content(atom.getProton(kClass))
        }
        fun content(proton: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField().getContent()
        }
        fun field(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : Field {
            return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.field(atom.getProton(ValueProton::class))
        }
        fun field(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, kClass: KClass<*>) : Field {
            return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.field(atom.getProton(kClass))
        }
        fun field(proton: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField()
        }
        fun format(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.field(atom))
        }
    }
    constructor() : this(
        MatterAntiMatter(symmetrical.cosmic.physics.atomic.atoms.Atom::class, symmetrical.cosmic.physics.atomic.atoms.Atom::class),
        Orbitals(),
        Nucleons()

    )
    init {
        setAtom(this)
        this.orbitals.setAtom(this)
        this._nucleons.setAtom(this)
    }

    constructor(content:Any?) : this() {
        Quark.value(this).setWavelength(content)
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = _nucleons.absorb(remainder)
        remainder = orbitals.absorb(remainder)

        setAtom(this)
        return remainder
    }

    fun accept(valueQuark: Down, zBoson: symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        valueQuark.getWavelength().setContent(zBoson.getNewValue())
        zBoson.setAccepted(true)
        return this
    }
    open fun capacitanceChange(me: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson) : symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson {
        return zBoson
    }
    fun capacitor_(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        capacitor(atom);
        return atom
    }
    fun _capacitor(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        capacitor(atom);
        return this
    }
    fun conductor_(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        conductor(atom, autoFlow);
        return atom
    }
    fun _conductor(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        conductor(atom, autoFlow);
        return this
    }
    fun conductor(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : Unit {
        diode(atom, autoFlow)
        atom.diode(this, autoFlow)
    }
    fun capacitor(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : Unit {
        val me : symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton = getCurrentValueProton()
        val you: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton = atom.getCurrentValueProton()

        me.ionicBond(you)
    }
    fun diode_(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        diode(atom, autoFlow)
        return atom
    }
    fun _diode(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        diode(atom, autoFlow)
        return this
    }
    fun diode(atom: symmetrical.cosmic.physics.atomic.atoms.Atom, autoFlow:Boolean=true) : Unit {
        val me : symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton = getCurrentValueProton()
        val you: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton = atom.getCurrentValueProton()

        me.covalentBond(you, autoFlow)
    }
    override fun emit() : Photon {
        return Photon(radiate())
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
    private fun getCurrentValueProton() : symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton {
        return getProtons().getProton(ValueProton::class)
    }
    fun getElectron(pos:Int) : symmetrical.cosmic._physics.subatomic.matter.leptons.Electron {
        return orbitals.get(pos) as symmetrical.cosmic._physics.subatomic.matter.leptons.Electron
    }
    fun getField() : Field {
        return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.field(this)
    }
    fun getField(proton:KClass<*>) : Field {
        return symmetrical.cosmic.physics.atomic.atoms.Atom.Companion.field(this, proton)
    }
    fun getProtons() : Protons {
        return _nucleons.getProtons()
    }
    fun reject(reasonCode:Int, reason:String, boson: symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        boson.setAccepted(false)
        boson.setReasonCode(reasonCode)
        boson.setReason(reason)
        return this;
    }
    final override fun setAtom(atom: symmetrical.cosmic.physics.atomic.atoms.Atom) : symmetrical.cosmic.physics.atomic.atoms.Atom {
        orbitals.setAtom(this)
        _nucleons.setAtom(this)
        return this
    }
    fun setContent(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().setCurrentValue(
            symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson().i(Field(value), constructing)).decay()
    }
    open fun valueChange(proton: symmetrical.cosmic._physics.subatomic.matter.hadrons.baryons.Proton, valueQuark: Down, zBoson: symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson) : symmetrical.cosmic._physics.subatomic.matter.bosons.ZBoson {
        accept(valueQuark, zBoson)
        return zBoson
    }

    private fun radiate() : String {
        if (symmetrical.cosmic._physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Atom")
        }
        val classId :String = matterAntiMatter.getClassId()
        val particle:String = super.emit().radiate()
        val nucleons:String = _nucleons.emit().radiate()
        val orbitals:String = orbitals.emit().radiate()
        return classId+particle+nucleons+orbitals
    }
}