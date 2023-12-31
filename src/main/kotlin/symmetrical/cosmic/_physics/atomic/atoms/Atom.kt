package symmetrical.cosmic._physics.atomic.atoms


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharge
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.balanced.quarks.IQuarkValue
import symmetrical.cosmic._physics._subatomic.balanced.quarks.QuarkValue
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic.dictionary.protons.ValueProton


open class Atom(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Atom::class, Atom::class),
    private   var orbitals          : Orbitals              = Orbitals(),
    public    var nucleons          : Nucleons              = Nucleons(),
    private   val colorCharges      : ColorCharge           = ColorCharge(),
    private   val quarkValue        : QuarkValue            = QuarkValue()

) : Particle(),
    IMatterAntiMatter       by matterAntiMatter,
    IOrbitals               by orbitals,
    INucleons               by nucleons,
    IColorCharge            by colorCharges,
    IQuarkValue             by quarkValue,
    Element,
    IEmitter,
    IAtom
{
    constructor() : this(
        MatterAntiMatter(Atom::class, Atom::class),
        Orbitals(),
        Nucleons(),
        ColorCharge(),
        QuarkValue(),
    )
    init {
        setAtom(this)
        this.orbitals.setAtom(this)
        this.nucleons.setAtom(this)
    }

    constructor(value:String) : this() {
        Quark.value(this).setWavelength(value)
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = orbitals.absorb(remainder)
        remainder = nucleons.absorb(remainder)

        setAtom(this)
        return remainder
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
        return nucleons.getProtons().getCurrentValue()
    }
    private fun getCurrentValueProton() : Proton {
        return getProtons().getCurrentValueProton()
    }
    fun getElectron(pos:Int) : Electron {
        return orbitals.get(pos) as Electron
    }
    fun getProtons() : Protons {
        return nucleons.getProtons()
    }

    final override fun setAtom(atom:Atom) : Atom {
        orbitals.setAtom(this)
        nucleons.setAtom(this)
        colorCharges.setAtom(this)
        return this
    }
    fun setCurrentValue(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
        return getProtons().setCurrentValue(ZBoson().i(Field(value), constructing)).decay()
    }
    override fun setElectronSpin(spin: Spin) : Atom {
        orbitals.setElectronSpin(spin)
        return this
    }
    override fun toString() : String {
        var up: Up = nucleons.getProton(ValueProton::class).getConstraintsQuark()
        val value:Any? = up.getWavelength()
        return value.toString()
    }
    open fun valueChange(proton: Proton, valueQuark: Down, zBoson: ZBoson) : ZBoson {
        valueQuark.getWavelength().setContent(zBoson.getNewValue())
        zBoson.setAccepted(true)
        return zBoson
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()+
                orbitals.emit().radiate()+
                nucleons.emit().radiate()
    }
}