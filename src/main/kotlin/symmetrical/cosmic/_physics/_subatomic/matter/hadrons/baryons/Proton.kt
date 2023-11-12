package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons


open class Proton : Baryon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    object Static {
        const val VALUE_QUARK : Int = Baryon.Static.LAST + 1
        const val FIELD_NAME  : Int = VALUE_QUARK        + 1
        const val LAST        : Int = FIELD_NAME         + 1
    }

    private lateinit var __protons: Protons
    constructor()  {
       this.Proton()
    // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
    // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
    // -1/3 wavelength(Type Of Proton),        Spin(?),
    }
    public override fun getIlluminations() : ParticleBeam {
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

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        val classId = getLocalClassId()
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate();
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Proton::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun getDown() : Down {
        return get(0) as Down
    }
    fun getQuarkValue() : Any? {
        return getValueQuark().wavelength()
    }
    fun getFieldName() : String {
        return getFieldNameQuark().wavelength() as String
    }
    private fun getFieldNameQuark() : Quark {
        return (get(Static.FIELD_NAME) as Quark)
    }
    private fun getValueQuark() : Quark {
        return (get(Static.VALUE_QUARK) as Quark)
    }

    fun setFieldName(name:String) : Proton {
        getFieldNameQuark().setWavelength(name)
        return this
    }
    fun setProtons(protons:Protons) : Proton {
        this.__protons = protons
        return this
    }
}