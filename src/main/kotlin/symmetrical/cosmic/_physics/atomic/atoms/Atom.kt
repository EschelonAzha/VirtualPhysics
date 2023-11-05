package symmetrical.cosmic._physics.atomic.atoms


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharges
import symmetrical.cosmic._physics._subatomic.balanced.color.IColorCharges
import symmetrical.cosmic._physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.balanced.quarks.IQuarkValue
import symmetrical.cosmic._physics._subatomic.balanced.quarks.QuarkValue


open class Atom(

    private   var orbitals      : Orbitals     = Orbitals(),
    public    var nucleons      : Nucleons     = Nucleons(),
    private   var particle      : Particle     = Particle(),
    private   val colorCharges  : ColorCharges = ColorCharges(),
    private   val quarkValue    : QuarkValue   = QuarkValue()
        )
    :
        Element,
        Emitter,
        IOrbitals       by orbitals,
        INucleons       by nucleons,
        IParticle by particle,
        IColorCharges by colorCharges,
        IQuarkValue by quarkValue
    {
        object Illuminations {
            public val beam: ParticleBeam = ParticleBeam()
        }
        init {
            setAtom(this)
        }
        constructor() : this(Orbitals(), Nucleons(), Particle(), ColorCharges(), QuarkValue()) {
            this.orbitals.setAtom(this)
            this.nucleons.setAtom(this)
        }
        constructor(value:String) : this() {
            setQuarkValue(value)
        }
        public open fun getIlluminations() : ParticleBeam {
            return Illuminations.beam
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
        final override fun setAtom(atom:Atom) : Atom {
            orbitals.setAtom(this)
            nucleons.setAtom(this)
            colorCharges.setAtom(this)
            quarkValue.setAtom(this)
            particle.setParent(this)
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
}