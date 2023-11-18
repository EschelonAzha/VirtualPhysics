package symmetrical.cosmic._physics.atomic.atoms


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharges
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharges
import symmetrical.cosmic._physics._subatomic.balanced.pairs.TauAntiTauPair
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.balanced.quarks.IQuarkValue
import symmetrical.cosmic._physics._subatomic.balanced.quarks.QuarkValue
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement


open class Atom(
    private   val entanglement  : QuantumEntanglement,
    private   var orbitals      : Orbitals,
    public    var nucleons      : Nucleons,
    private   var particle      : Particle,
    private   val colorCharges  : ColorCharges,
    private   val quarkValue    : QuarkValue,

        )
    :
        IQuantumEntanglement    by entanglement,
        IOrbitals               by orbitals,
        INucleons               by nucleons,
        IParticle               by particle,
        IColorCharges           by colorCharges,
        IQuarkValue             by quarkValue,
        Element,
        Emitter,
        IAtom
    {
        constructor() : this(
            QuantumEntanglement(),
            Orbitals(),
            Nucleons(),
            Particle(),
            ColorCharges(),
            QuarkValue()
        ) {
//            this.orbitals.setAtom(this)
//            this.nucleons.setAtom(this)
        }

        init {
            setAtom(this)
            this.orbitals.setAtom(this)
            this.nucleons.setAtom(this)

        }

        constructor(value:String) : this() {
            setQuarkValue(value)
        }

        private fun check(photon: Photon) : Unit {
            val classId = getLocalClassId()

            val radiation = photon.radiate()
            if (radiation.startsWith(classId))
                return
            println("Radiation Leak in: "+this::class.simpleName)
            return;
        }
        override fun absorb(photon: Photon) : Photon {
            check(photon);

            val remainder = particle.absorb(photon.propagate())
            var (orbitals, orbitalsRemainder) = Absorber.materialize(remainder.radiate())
            var (nucleons, nucleonsRemainder) = Absorber.materialize(orbitalsRemainder)
            this.orbitals   = orbitals as Orbitals
            this.nucleons   = nucleons as Nucleons
            setAtom(this)
            return Photon(nucleonsRemainder)
        }
        override fun emit() : Photon {
            return Photon(radiate())
        }
        private fun radiate() : String {
            return getLocalClassId()+particle.emit().radiate()+orbitals.emit().radiate()+nucleons.emit().radiate()
        }
        private fun getLocalClassId(): String {
            return Absorber.getClassId(Atom::class)
        }
        override fun getClassId() : String {
            return getLocalClassId()
        }
        fun getFieldName() : String {
            return getValueProton().getFieldName()
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
            quarkValue.setAtom(this)
            particle.setSelf(this)
            return this
        }
        fun setFieldName(name:String) : Atom {
            getValueProton().setFieldName(name)
            return this
        }
        override fun toString() : String {
            var down: Down = nucleons.getValueProton().getDown()
            val value:Any? = down.getValue()
            return value.toString()
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
        fun conductor(atom: Atom, autoFlow:Boolean=true) : Unit {
            diode(atom, autoFlow)
            atom.diode(this, autoFlow)
        }
        fun capacitor(atom: Atom) : Unit {
            val me : Proton = getCurrentValueProton()
            val you: Proton = atom.getCurrentValueProton()

            me.ionicBond(you)
        }
        fun getCurrentValue() : Any? {
            return nucleons.getProtons().getCurrentValue()
        }
        private fun getCurrentValueProton() : Proton {
            return getProtons().getCurrentValueProton()
        }

        fun setCurrentValue(value:Any?, constructing:Boolean=false) : TauAntiTauPair {
            return getProtons().setCurrentValue(ZBoson().i(Field(value), constructing)).decay()
        }
        open fun capacitanceChange(me: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
            return zBoson
        }
        open fun valueChange(proton: Proton, valueQuark: Up, zBoson: ZBoson) : ZBoson {
            valueQuark.getWavelength().setWavelength(zBoson.getNewValue())
            zBoson.setAccepted(true)
            return zBoson
        }


    }