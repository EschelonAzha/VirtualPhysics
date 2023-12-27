package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_hadrons.anti_baryons.AntiProton
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.leptons.Electron
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons


open class Proton(
    private val matter: IMatter = Matter(Proton::class, AntiProton::class),
) : Baryon(),
    IMatter by matter
{
    constructor() : this(
        Matter(Proton::class, AntiProton::class),
    ) init {
        this.Proton()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
        // -1/3 wavelength(Type Of Proton),        Spin(?),
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

    fun i(protons:Protons) : Proton {
        this.__protons = protons
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    fun capacitanceChange(zBoson:ZBoson) : ZBoson {
        if (__protons != null)
            __protons!!.capacitanceChange(this, getValueQuark(), zBoson)

        return zBoson
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

    override fun emit() : Photon {
        val classId = matter.getClassId()
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun getDown() : Down {
        return get(QuarkType.TYPE.value) as Down
    }

    fun getField() : Field {
        return getValueQuark().getWavelength().getField()
    }
    fun getFieldName() : String {
        return getFieldNameQuark().wavelength() as String
    }
    fun getQuarkValue() : Any? {
        return getValueQuark().wavelength()
    }
    fun getValidatorQuark() : Up {
        return get(QuarkType.VALIDATOR.value) as Up
    }
    public fun getValue() : Any? {
        return getField().getValue()
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
    fun interact(zBoson: ZBoson) : ZBoson {
        if (flowing)
            return zBoson

        val newValue  : Field                       = zBoson.getNewField()
        val valueQuark: Up                          = getValueQuark()
        val wavelength: QuantumField                = valueQuark.getWavelength().getQuantumField()
        zBoson.setOldValue(wavelength.getValue())

        if (!noChange(zBoson).isAccepted())
            return zBoson // not accepted, nothing changed

        var accept = valueChange(valueQuark, zBoson)
        if (!zBoson.isAccepted()) {
            return zBoson  // preValueChange rejected change
        }

        if (autoFlow) {
            flowing = true
            val beam: ParticleBeam = flow() // beam has the remote changes.   Not being used yet
            flowing = false
        }

        return zBoson  // this returns only the local changes
    }
    fun isType(type: QuarkType) : Boolean {
        val protonType = getTypeQuark().getWavelength().getField().toInt()
        return protonType == type.value
    }

    fun setFieldName(name:String) : Proton {
        getFieldNameQuark().setWavelength(name)
        return this
    }
    fun setProtons(protons:Protons) : Proton {
        this.__protons = protons
        return this
    }

    fun setType(protonType: Protons.ProtonType) : Proton {
        val wavelength: QuantumField = getTypeQuark().getWavelength().getQuantumField()
        val changed = wavelength.setValue(protonType.value.toString())
        return this
    }

    private fun flow() : ParticleBeam {
        val electron: Electron = getElectron() ?: return ParticleBeam()
        return electron.flow()
    }
    private fun getElectron() : Electron? {
        val electron : Electron = __protons?.getElectron(this) ?: return null

        electron.setProton(this)

        return electron
    }
    private fun getFieldNameQuark() : Quark {
        return (get(Static.FIELD_NAME) as Quark)
    }
    private fun getTypeQuark() : Down {
        return get(QuarkType.TYPE.value) as Down
    }
    private fun getValueQuark() : Up {
        return get(QuarkType.VALUE.value) as Up
    }

    private fun noChange(zBoson:ZBoson) : ZBoson {
        val newValue  : Field                   = zBoson.getNewField()
        val valueQuark: Up                      = getValueQuark()
        val wavelength: QuantumField            = valueQuark.getWavelength().getQuantumField()
        if (!wavelength.isChange(newValue)) {
            zBoson.setAccepted(false)
        }
        zBoson.setAccepted(true)
        return zBoson
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate();
    }
    private fun valueChange(valueQuark:Up, zBoson:ZBoson) : ZBoson {
        if (__protons != null)
            __protons!!.valueChange(this, valueQuark, zBoson)
        return zBoson
    }


}