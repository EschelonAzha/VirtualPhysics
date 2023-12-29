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
        this.add(Down())  // value
        this.add(Up())    // Format
        this.add(Up())    // Constraints

        shrink()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
        // -1/3 wavelength(Type Of Proton),        Spin(?),
    }

    enum class QuarkType(val value:Int) {
        VALUE(0),
        FORMAT(1),
        CONSTRAINTS(2),
    }

    object Static {

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
    fun getConstraints() : Up {
        return get(QuarkType.CONSTRAINTS.value) as Up
    }
    public fun getContent() : Any? {
        return getField().getContent()
    }

    fun getField() : Field {
        return getValueQuark().getWavelength().getField()
    }

    fun getFormat() : Up {
        return get(QuarkType.FORMAT.value) as Up
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
        zBoson.setOldValue(wavelength.getContent())

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


    fun setProtons(protons:Protons) : Proton {
        this.__protons = protons
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