package symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons

import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.subatomic.matter.quarks.Down
import symmetrical.cosmic.physics.subatomic.matter.quarks.Up
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.luminescent.QuasiParticle
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_baryons.AntiProton
import symmetrical.cosmic.physics.subatomic.balanced.IParticle
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Proton
 */
open class Proton(
    private val matter: IMatter = Matter(Proton::class, AntiProton::class),
) : Baryon(),
    IMatter by matter
{
    var _quark:Quark
    constructor() : this(
        Matter(Proton::class, AntiProton::class),
    ) init {
        _quark = this.Proton()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
        // -1/3 wavelength(Type Of Proton),        Spin(?),
    }

    enum class QuarkType(val value:Int) {
        VALUE(0),
        CONSTRAINTS(1),
        UP(2),
    }

    object Static {

    }

    private var p_protons       : Protons? = null
    private var autoFlow        : Boolean  = true
    private var flowing         : Boolean  = false

    fun i(protons:Protons) : Proton {
        this.p_protons = protons
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        clear()
        var remainder = photon.propagate()

        remainder = super.absorb(remainder)

        _quark    = get(0) as Quark
        return remainder
    }
    fun capacitanceChange(zBoson: ZBoson) : ZBoson {
        if (p_protons != null)
            p_protons!!.capacitanceChange(this, getValueQuark(), zBoson)

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
    fun getConstraintsQuark() : Up {
        return get(Proton.QuarkType.CONSTRAINTS.value) as Up
    }

    fun getUpQuark() : Up {
        return get(Proton.QuarkType.UP.value) as Up
    }
    fun getValueQuark() : Down {
        return get(Proton.QuarkType.VALUE.value) as Down
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
        val valueQuark: Down                        = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
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
    override fun set(pos:Int, quark: IParticle) : IParticle {
        super.set(pos, quark)
        if (pos == 0)
            _quark = quark as Quark
        return quark
    }

    fun setProtons(protons:Protons) : Proton {
        this.p_protons = protons
        return this
    }


    private fun flow() : ParticleBeam {
        val electron: Electron = getElectron() ?: return ParticleBeam()
        return electron.flow()
    }
    private fun getElectron() : Electron? {
        val electron : Electron = p_protons?.getElectron(this) ?: return null

        electron.setProton(this)

        return electron
    }


    private fun noChange(zBoson: ZBoson) : ZBoson {
        val newValue  : Field                   = zBoson.getNewField()
        val valueQuark: Down                    = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
        if (!wavelength.isChange(newValue)) {
            zBoson.setAccepted(false)
        }
        zBoson.setAccepted(true)
        return zBoson
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Proton")
        }

        val classId : String = matter.getClassId()
        val baryon  : String = super.emit().radiate()
        return classId+baryon
    }
    private fun valueChange(valueQuark:Down, zBoson: ZBoson) : ZBoson {
        if (p_protons != null)
            p_protons!!.valueChange(this, valueQuark, zBoson)
        return zBoson
    }


}