package symmetrical.cosmic._physics.atomic.atoms


import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharge
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Atom
 */

open class Atom(
    private   val matterAntiMatter  : IMatterAntiMatter     = MatterAntiMatter(Atom::class, Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var _nucleons         : Nucleons              = Nucleons()

) : Particle(),
    IMatterAntiMatter       by matterAntiMatter,
    IOrbitals               by orbitals,
    INucleons               by _nucleons,
    Element,
    IEmitter,
    IAtom
{
    companion object {
        fun content(atom: Atom) : Any? {
            return content(atom.getProton(ValueProton::class))
        }
        fun content(atom: Atom, kClass: KClass<*>) : Any? {
            return content(atom.getProton(kClass))
        }
        fun content(proton:Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField().getContent()
        }
        fun field(atom: Atom) : Field {
            return field(atom.getProton(ValueProton::class))
        }
        fun field(atom: Atom, kClass: KClass<*>) : Field {
            return field(atom.getProton(kClass))
        }
        fun field(proton: Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getWavelength().getField()
        }
        fun format(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(field(atom))
        }
    }
    constructor() : this(
        MatterAntiMatter(Atom::class, Atom::class),
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
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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
        return Atom.field(this)
    }
    fun getField(proton:KClass<*>) : Field {
        return Atom.field(this, proton)
    }
    fun getProtons() : Protons {
        return _nucleons.getProtons()
    }
    fun reject(reasonCode:Int, reason:String, boson:ZBoson) : Atom {
        boson.setAccepted(false)
        boson.setReasonCode(reasonCode)
        boson.setReason(reason)
        return this;
    }
    final override fun setAtom(atom:Atom) : Atom {
        orbitals.setAtom(this)
        _nucleons.setAtom(this)
        return this
    }
    fun setContent(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().setCurrentValue(ZBoson().i(Field(value), constructing)).decay()
    }
    open fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        accept(valueQuark, zBoson)
        return zBoson
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()+
                orbitals.emit().radiate()+
                _nucleons.emit().radiate()
    }
}