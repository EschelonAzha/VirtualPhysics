package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons


open class Proton : Baryon {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }

    enum class QuarkType(val value:Int) {
        VALUE(0),
        VALIDATOR(1),
        TYPE(2),

    }

    object Static {
        const val VALUE_QUARK   : Int = Baryon.Static.LAST + 1
        const val FIELD_NAME    : Int = VALUE_QUARK        + 1
        const val LAST          : Int = FIELD_NAME         + 1
    }

    private var __protons       : Protons? = null
    private var autoFlow        : Boolean  = true
    private var flowing         : Boolean  = false
    constructor()  {
       this.Proton()
    // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
    // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
    // -1/3 wavelength(Type Of Proton),        Spin(?),
    }
    fun i(protons:Protons) : Proton {
        this.__protons = protons
        return this
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
        return get(QuarkType.TYPE.value) as Down
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
//    private fun getValueQuark() : Quark {
//        return (get(Static.VALUE_QUARK) as Quark)
//    }

    fun getField() : Field {
        return getValueQuark().getWavelength().getField()
    }

    fun setFieldName(name:String) : Proton {
        getFieldNameQuark().setWavelength(name)
        return this
    }
    fun setProtons(protons:Protons) : Proton {
        this.__protons = protons
        return this
    }

    fun covalentBond(proton: Proton, autoFlow:Boolean = true) : Proton {
        proton.autoFlow = autoFlow
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.covalentBond(youElectron)
        return this
    }
    fun ionicBond(proton: Proton) : Proton {
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.ionicBond(youElectron)
        return this
    }
    private fun getElectron() : Electron? {
        val electron : Electron = __protons?.getElectron(this) ?: return null

        electron.setProton(this)

        return electron
    }
    fun isType(type: QuarkType) : Boolean {
        val protonType = getTypeQuark().getWavelength().getField().toInt()
        return protonType == type.value
    }
    fun setType(protonType: Protons.ProtonType) : Proton {
        val wavelength: Wavelength = getTypeQuark().getWavelength()
        val changed = wavelength.setWavelength(protonType.value.toString())
        return this
    }
    fun getValue() : Any? {
        return getField().getValue()
    }

    fun interact(zBoson: ZBoson) : ZBoson {
        if (flowing)
            return zBoson

        val newValue  : Field      = zBoson.getNewField()
        val valueQuark: Up         = getValueQuark()
        val wavelength: Wavelength = valueQuark.getWavelength()
        zBoson.setOldValue(wavelength.getValue())

        if (!noChange(zBoson).isAccepted())
            return zBoson // not accepted, nothing changed

        var accept = valueChange(valueQuark, zBoson)
        if (!zBoson.isAccepted()) {
            return zBoson  // preValueChange rejected change
        }

        if (autoFlow) {
            flowing = true
            val beam:ParticleBeam = flow() // beam has the remote changes.   Not being used yet
            flowing = false
        }

        return zBoson  // this returns only the local changes
    }
    private fun getValueQuark() : Up {
        return get(QuarkType.VALUE.value) as Up
    }
    fun getValidatorQuark() : Up {
        return get(QuarkType.VALIDATOR.value) as Up
    }
    private fun getTypeQuark() : Down {
        return get(QuarkType.TYPE.value) as Down
    }
    fun capacitanceChange(zBoson:ZBoson) : ZBoson {
        if (__protons != null)
            __protons!!.capacitanceChange(this, getValueQuark(), zBoson)

        return zBoson
    }
    private fun valueChange(valueQuark:Up, zBoson:ZBoson) : ZBoson {
        if (__protons != null)
            __protons!!.valueChange(this, valueQuark, zBoson)
        return zBoson
    }
    private fun flow() : ParticleBeam {
        val electron: Electron = getElectron() ?: return ParticleBeam()
        return electron.flow()
    }
    private fun noChange(zBoson:ZBoson) : ZBoson {
        val newValue  : Field      = zBoson.getNewField()
        val valueQuark: Up         = getValueQuark()
        val wavelength: Wavelength = valueQuark.getWavelength()
        if (!wavelength.isChange(newValue)) {
            zBoson.setAccepted(false)
        }
        zBoson.setAccepted(true)
        return zBoson
    }
}